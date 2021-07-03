package com.faztbit.lesson4.ui.login

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.faztbit.lesson4.databinding.ActivityMainBinding
import com.faztbit.lesson4.gonnaToActivity
import com.faztbit.lesson4.models.Constants.PREFIX_LASTNAME
import com.faztbit.lesson4.models.Constants.PREFIX_NAME
import com.faztbit.lesson4.models.Constants.SESSION
import com.faztbit.lesson4.models.User
import com.faztbit.lesson4.showMessage
import com.faztbit.lesson4.ui.products.ListProductActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreference = getSharedPreferences("Lesson4", 0)
        validateIfExistSession()
    }

    override fun onResume() {
        super.onResume()
        events()
    }

    private fun validateIfExistSession() {
        val session = sharedPreference.getBoolean(SESSION, false)
        if (session) processIntent()
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
                processInformation()
                processIntent()
            } else {
                showMessage("El usuario y contraseña son incorrectos!")
            }
        }
    }

    private fun processInformation() {
        val user = User("edmundo@gmail.com", "Edmundo", "Prado")
        sharedPreference.edit().apply {
            putBoolean(SESSION, true)
            putString(PREFIX_NAME, user.name)
            putString(PREFIX_LASTNAME, user.lastName)
        }.commit()
    }

    private fun processIntent() {
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