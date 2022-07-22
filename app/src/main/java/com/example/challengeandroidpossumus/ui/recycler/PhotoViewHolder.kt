package com.example.challengeandroidpossumus.ui.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeandroidpossumus.databinding.ItemPhotoBinding
import com.squareup.picasso.Picasso

class PhotoViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var binding = ItemPhotoBinding.bind(view)

    fun bind(url: String){
        Picasso.get().load(url).into(binding.ivPhoto)
    }
}