package com.danscoding.evenity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danscoding.evenity.databinding.ActivityWelcome1Binding

class WelcomeActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityWelcome1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcome1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNext.setOnClickListener { intentButtonToSignIn() }

    }

    private fun intentButtonToSignIn() {
        val intent = Intent(this@WelcomeActivity1, SignInActivity::class.java)
        startActivity(intent)
    }
}