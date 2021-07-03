package com.faztbit.lesson4.ui.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.faztbit.lesson4.databinding.ActivityListProductBinding


class ListProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}