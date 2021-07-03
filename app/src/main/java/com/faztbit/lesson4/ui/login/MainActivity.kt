package com.faztbit.lesson4.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.faztbit.lesson4.databinding.ActivityMainBinding
import com.faztbit.lesson4.gonnaToActivity
import com.faztbit.lesson4.showMessage
import com.faztbit.lesson4.ui.products.ListProductActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        events()
    }


    private fun events() {
        with(binding) {
            textViewForgotPassword.setOnClickListener {

            }
            buttonLogin.setOnClickListener {
                processLogin()
            }
        }
    }

    private fun processLogin() {
        with(binding) {
            val user = textInputEditTextEmail.text.toString()
            val pass = textInputEditTextPassword.text.toString()

            if (validateTextFieldIfEmpty(user, pass)) {
                showMessage("Por favor ingrese su email o contraseña!")
            } else if (validateIfUserIsCorrect(user, pass)) {
                processIntent(user, pass)
            } else {
                showMessage("El usuario y contraseña son incorrectos!")
            }

        }
    }

    private fun processIntent(user: String, pass: String) {
        gonnaToActivity(ListProductActivity::class.java)
    }

    private fun validateIfUserIsCorrect(user: String, password: String): Boolean {
        return user.equals("edmundo") && password.equals("123")
    }

    private fun validateTextFieldIfEmpty(user: String, password: String): Boolean {
        if (user.isEmpty()) {
            return true
        } else if (password.isEmpty()) {
            return true
        }
        return false
    }
}