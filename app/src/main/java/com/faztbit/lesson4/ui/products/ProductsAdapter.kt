package com.faztbit.lesson4.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faztbit.lesson4.R
import com.faztbit.lesson4.databinding.ItemProductsBinding
import com.faztbit.lesson4.models.Products

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    var list = emptyList<Products>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)

    }

    override fun getItemCount() = list.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemProductsBinding.bind(view)

        fun bind(products: Products) {
            with(binding) {
                textViewProduct.text = products.name
                textViewPrice.text = products.price.toString()
            }
        }
    }

}