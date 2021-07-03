package com.faztbit.lesson4.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faztbit.lesson4.data.RoomRepository
import com.faztbit.lesson4.models.Products
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListProductViewModel(private val repository: RoomRepository) : ViewModel() {
    //    private var _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>> get() = repository.getAllProducts()

    fun addProduct(products: Products) {
        GlobalScope.launch {
            repository.addProduct(products)
        }
    }

    fun removeProduct(products: Products) {
        GlobalScope.launch {
            repository.deleteProduct(products)
        }
    }
}