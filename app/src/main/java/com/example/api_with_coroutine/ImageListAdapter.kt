package com.example.api_with_coroutine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.api_with_coroutine.databinding.ImageListBinding
import com.example.api_with_coroutine.databinding.ListItemBinding

class ImageListAdapter(var imageList:ArrayList<String>) : RecyclerView.Adapter<ImageListAdapter.ImageListAdapterViewMdel>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListAdapterViewMdel {
        var binding = ImageListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageListAdapterViewMdel(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageListAdapterViewMdel, position: Int) {

        holder.binding.imageView.load(imageList[position])
    }

    class ImageListAdapterViewMdel(var binding: ImageListBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

}