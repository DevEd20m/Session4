package com.faztbit.lesson4.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.faztbit.lesson4.data.RoomRepository

class ListProductViewModelFactory(private val repository: RoomRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListProductViewModel(repository) as T
    }
}