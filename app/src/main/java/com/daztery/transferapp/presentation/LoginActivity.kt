package com.daztery.transferapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import com.daztery.transferapp.databinding.ActivityLoginBinding
import com.daztery.transferapp.presentation.adapter.login.ButtonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var adapter: ButtonAdapter
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread.sleep(1000)
        screenSplash.setKeepOnScreenCondition { false }
        setupButtonRecyclerView()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setupButtonRecyclerView() {
        val buttons = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9") // Mock

        adapter = ButtonAdapter(buttons) { value ->
            password += value
            binding.txtPassword.text = password
            if(password.length == 3){
                validatePassword(password)
            }
        }
        binding.rvButtons.layoutManager = GridLayoutManager(this, 3)
        binding.rvButtons.adapter = adapter
    }

    private fun validatePassword(value: String) {
        if (value == "123") {
            navigateToMainActivity()
        } else {
            binding.txtPassword.text = "Escribe la contraseña correcta"
            password = ""
        }
    }

}