package com.faztbit.lesson4.ui.products

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.faztbit.lesson4.data.RoomRepository
import com.faztbit.lesson4.databinding.ActivityListProductBinding
import com.faztbit.lesson4.models.Constants.PREFIX_NAME


class ListProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListProductBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var adapterMain: ProductsAdapter
    private lateinit var viewModel: ListProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpSharedPreference()
        setInformationView()
        setUpViewModel()
        setUpRecyclerView()
        setUpViewModelObservers()
    }

    private fun setUpSharedPreference() {
        sharedPreferences = getSharedPreferences("Lesson4", 0)
    }

    private fun setInformationView() {
        binding.textViewNameUser.text = sharedPreferences.getString(PREFIX_NAME, null)
    }

    private fun setUpRecyclerView() {
        with(binding.recyclerViewProducts) {
            adapterMain = ProductsAdapter()
            adapter = adapterMain
            layoutManager = LinearLayoutManager(this@ListProductActivity)
        }
    }

    private fun setUpViewModel() {
        val factory = ListProductViewModelFactory(RoomRepository())
        viewModel = ViewModelProviders.of(this, factory)[ListProductViewModel::class.java]
    }

    private fun setUpViewModelObservers() {
        with(viewModel) {
            products.observe(this@ListProductActivity, {
                it?.let {
                    adapterMain.list = it
                }
            })
        }
    }

}