package com.danscoding.evenity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.danscoding.evenity.api.ApiConfig
import com.danscoding.evenity.databinding.ActivitySignInBinding
import com.danscoding.evenity.model.LoginModel
import com.danscoding.evenity.preference.UserPreference
import com.danscoding.evenity.response.LoginResponse
import com.danscoding.evenity.viewmodel.MainViewModel
import com.danscoding.evenity.viewmodel.ViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private val Context.dataStore : DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore(name = "token")

    private lateinit var binding : ActivitySignInBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var login : LoginResponse
    private lateinit var preference: UserPreference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signin()
        setupViewModel()
        binding.buttonRegister.setOnClickListener { intentToRegister() }
        //CUSTOMVIEW PASSWORD
        binding.passwordEditText.doOnTextChanged { text, _, _, _ ->
            if (text!!.length < 6) {
                binding.passwordEditTextLayout.error = "minimal password 6 huruf"
            } else {
                binding.passwordEditTextLayout.error = null
            }
        }
    }

    private fun validationEmail():String? {
        val validEmail = binding.emailEditText.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(validEmail).matches()) {
            return "Email tidak valid"
        } else {
            signin()
        }
        return null
    }

    private fun setupViewModel() {
        val preference = UserPreference.getInstanceUser(dataStore)
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(preference)
        )[MainViewModel::class.java]
        viewModel.tokenGet().observe(this){login ->
            this.login = login
        }
    }

    private fun signin() {
        binding.buttonSignIn.setOnClickListener {
            val emailUser = binding.emailEditText.text.toString()
            val passwordUser = binding.passwordEditText.text.toString().trim()
            val roleUser = "client"

            when {
                emailUser.isEmpty() -> {
                    binding.emailEditTextLayout.error = "Masukkan Email Anda"
                }
                passwordUser.isEmpty() -> {
                    binding.passwordEditTextLayout.error = "Masukkan Password Anda"
                }
                else -> {
                    binding.emailEditTextLayout.error = validationEmail()
                }
            }
            showLoading(true)
            ApiConfig().getApiService()
                .loginUser("application/json",
                LoginModel(emailUser, passwordUser, roleUser)
                )
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        showLoading(false)
                        val responseBody = response.body()
                        if (response.isSuccessful && responseBody != null) {
                            viewModel.tokenSave(
                                LoginResponse(false,
                            login.token,
                                true))
                            Toast.makeText(applicationContext, "Selamat Datang",
                            Toast.LENGTH_SHORT).show()
                            val intentUser = Intent(this@SignInActivity, MainActivity::class.java)
                            intentUser.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intentUser)
                            finish()
                        } else {
                            showLoading(false)
                            Toast.makeText(applicationContext,
                            "Email dan Password tidak sesuai",
                            Toast.LENGTH_SHORT).show()
                            Log.d(
                                SignInActivity::class.java.simpleName, response.body()?.error.toString())
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.d("failure: ", t.message.toString())
                    }
                })
        }
    }

    private fun showLoading(isLoading : Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun intentToRegister() {
        val intent = Intent(this@SignInActivity, RegisterActivity::class.java)
        startActivity(intent)
    }
}