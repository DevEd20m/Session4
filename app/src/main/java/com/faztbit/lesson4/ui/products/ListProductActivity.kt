package com.faztbit.lesson4.ui.products

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.faztbit.lesson4.data.ProductDatabase
import com.faztbit.lesson4.data.RoomRepository
import com.faztbit.lesson4.databinding.ActivityListProductBinding
import com.faztbit.lesson4.gonnaToActivity
import com.faztbit.lesson4.models.Constants.PREFIX_NAME
import com.faztbit.lesson4.models.Products
import com.faztbit.lesson4.ui.detail.DetailProductActivity


class ListProductActivity : AppCompatActivity(), ProductsAdapter.ProductAdapterListener {
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
        events()
    }


    private fun events() {
        binding.floatingButton.setOnClickListener {
            viewModel.addProduct(
                Products(
                    null,
                    "Producto ${Math.random().toInt()}",
                    Math.random().toInt().toDouble(), 1.0, false
                )
            )
        }
    }

    private fun setUpSharedPreference() {
        sharedPreferences = getSharedPreferences("Lesson4", 0)
    }

    private fun setInformationView() {
        binding.textViewNameUser.text = sharedPreferences.getString(PREFIX_NAME, null)
    }

    private fun setUpRecyclerView() {
        with(binding.recyclerViewProducts) {
            adapterMain = ProductsAdapter(this@ListProductActivity)
            adapter = adapterMain
            layoutManager = LinearLayoutManager(this@ListProductActivity)
        }
    }

    private fun setUpViewModel() {
        val roomInstance = ProductDatabase.getDataBaseInstance(this)
        val factory = ListProductViewModelFactory(RoomRepository(roomInstance))
        viewModel = ViewModelProviders.of(this, factory)[ListProductViewModel::class.java]
    }

    private fun setUpViewModelObservers() {
        with(viewModel) {
            products.observe(this@ListProductActivity, {
                it?.let {
                    adapterMain.list = it
                    adapterMain.notifyDataSetChanged()
                }
            })
        }
    }

    override fun remove(products: Products) {
        viewModel.removeProduct(products)
    }

    override fun passDataToDetail(products: Products) {
        gonnaToActivity(DetailProductActivity::class.java, DetailProductActivity.PRODUCT, products)
    }

}