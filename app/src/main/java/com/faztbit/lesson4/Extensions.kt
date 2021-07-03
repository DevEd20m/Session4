package com.faztbit.lesson4

import android.content.Context
import android.content.Intent
import android.widget.Toast

fun Context.showMessage(value: String) {
    Toast.makeText(this, value, Toast.LENGTH_LONG).show()
}

fun Context.gonnaToActivity(classNew: Class<*>) {
    val intent = Intent(this, classNew)
    startActivity(intent)
}