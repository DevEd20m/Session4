package com.faztbit.lesson4.data

import com.faztbit.lesson4.models.Products

class RoomRepository {

    fun returnList(): List<Products> {
        val listProduct = arrayListOf<Products>()
        listProduct.add(Products(1, "Panetón", 25.0))
        listProduct.add(Products(2, "Mantequilla", 5.0))
        listProduct.add(Products(3, "Polo", 43.0))
        listProduct.add(Products(4, "Camisa", 45.0))
        listProduct.add(Products(5, "Jabón", 5.0))
        listProduct.add(Products(6, "Lapicero", 1.0))
        listProduct.add(Products(7, "Plumón", 2.0))
        listProduct.add(Products(8, "Pantalón", 2.0))
        listProduct.add(Products(9, "Laptop", 2.0))
        listProduct.add(Products(10, "Detergente", 2.0))
        listProduct.add(Products(11, "Tenedor", 2.0))
        listProduct.add(Products(12, "Cuaderno", 2.0))
        listProduct.add(Products(13, "Impresora", 2.0))
        return listProduct
    }
}