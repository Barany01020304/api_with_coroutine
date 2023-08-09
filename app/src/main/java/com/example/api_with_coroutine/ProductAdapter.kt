package com.example.api_with_coroutine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.api_with_coroutine.databinding.ListItemBinding

class ProductAdapter(var productList: List<Product>,var onItemClick: ONItemClick) :
    RecyclerView.Adapter<ProductAdapter.ProductAdapterViewMdel>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewMdel {
        var binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductAdapterViewMdel(binding,onItemClick)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductAdapterViewMdel, position: Int) {
        var currentItem=productList[position]
        holder.binding.brandText.text=currentItem.brand
        holder.binding.titleText.text=currentItem.title
        holder.binding.descText.text=currentItem.description
        holder.binding.phoneImage.load(currentItem.thumbnail)
        holder.binding.priceText.text=currentItem.price.toString()
        holder.binding.priceOffText.text=currentItem.discountPercentage.toString()
    }

    class ProductAdapterViewMdel(var binding: ListItemBinding,onItemClick: ONItemClick) :
        RecyclerView.ViewHolder(binding.root) {
            init {
                binding.root.setOnClickListener {
                    onItemClick.onItemClick(adapterPosition)
                }
            }

    }

    interface ONItemClick {
        fun onItemClick(position: Int)
    }
}