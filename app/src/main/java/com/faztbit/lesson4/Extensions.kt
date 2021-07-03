package com.faztbit.lesson4

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.faztbit.lesson4.models.Products
import java.io.Serializable

fun Context.showMessage(value: String) {
    Toast.makeText(this, value, Toast.LENGTH_LONG).show()
}

fun Context.gonnaToActivity(classNew: Class<*>, keyValue: String? = null, obj: Serializable? = null){
    val intent = Intent(this, classNew)
    if(keyValue != null)
        intent.putExtra(keyValue, obj)
    startActivity(intent)
}