package com.faztbit.lesson4.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.faztbit.lesson4.models.Products

@Dao
interface ProductsDao {

    @Query("SELECT * FROM PRODUCTS")
    fun getALlProduct(): LiveData<List<Products>>

    @Query("DELETE FROM PRODUCTS WHERE Id =:idProduct")
    fun delete(idProduct: Int?)

    @Insert
    fun registerProduct(product: Products)

    @Delete
    fun removeProduct(product: Products)

}