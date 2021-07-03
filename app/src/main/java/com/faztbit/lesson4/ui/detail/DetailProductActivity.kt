package com.faztbit.lesson4.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.faztbit.lesson4.databinding.ActivityDetailProductBinding
import com.faztbit.lesson4.models.Products

class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding
    private var product: Products? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recoverProduct()
        setValueViews(product)
    }

    private fun recoverProduct() {
        product = intent.extras?.getSerializable(PRODUCT) as Products
    }

    private fun setValueViews(products: Products?) {
        with(binding) {
            textViewNameProduct.text = products?.name
            textViewNamePrice.text = products?.price.toString()
        }
    }

    companion object {
        const val PRODUCT = "PRODUCT"
    }
}