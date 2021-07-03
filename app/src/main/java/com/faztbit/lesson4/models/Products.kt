package com.faztbit.lesson4.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Products")
data class Products(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    val id: Int?,
    @ColumnInfo(name = "Name")
    val name: String,
    @ColumnInfo(name = "Price")
    val price: Double,
    @ColumnInfo(name = "Igv")
    val igv: Double?,
    @ColumnInfo(name = "IsFree")
    val isFree: Boolean?
) : Serializable