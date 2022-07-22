package com.example.challengeandroidpossumus.ui.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeandroidpossumus.databinding.ItemAlbumesBinding

class AlbumViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var binding = ItemAlbumesBinding.bind(view)

    fun bind(title: String, userId: Int) {
        binding.tvTitleAlbum.text = title
        binding.tvUserId.text = userId.toString()
    }
}