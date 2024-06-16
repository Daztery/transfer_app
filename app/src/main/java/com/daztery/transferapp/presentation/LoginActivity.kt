package com.daztery.transferapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.daztery.transferapp.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread.sleep(1000)
        screenSplash.setKeepOnScreenCondition { false }
        getPassword()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun getPassword() {
        var password = ""
        binding.apply {
            btn1.setOnClickListener {
                password = password.plus("1")
                txtPassword.text = password
                checkPasswordLength(password)
            }
            btn2.setOnClickListener {
                password = password.plus("2")
                txtPassword.text = password
                checkPasswordLength(password)
            }
            btn3.setOnClickListener {
                password = password.plus("3")
                txtPassword.text = password
                checkPasswordLength(password)
            }
        }
    }

    private fun checkPasswordLength(password: String) {
        if (password.length == 3) {
            validatePassword(password)
        }
    }

    private fun validatePassword(password: String) {
        if (password == "123") {
            navigateToMainActivity()
        }
    }

}