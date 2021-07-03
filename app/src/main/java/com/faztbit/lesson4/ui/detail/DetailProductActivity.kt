package com.faztbit.lesson4.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.faztbit.lesson4.databinding.ActivityDetailProductBinding

class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}