package com.danscoding.evenity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danscoding.evenity.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener { intentToRegister() }
        binding.buttonSignIn.setOnClickListener { intentToHome() }

    }

    private fun intentToRegister() {
        val intent = Intent(this@SignInActivity, RegisterActivity::class.java)
        startActivity(intent)
    }
    private fun intentToHome() {
        val intentHome = Intent(this@SignInActivity, MainActivity::class.java)
        startActivity(intentHome)
    }
}