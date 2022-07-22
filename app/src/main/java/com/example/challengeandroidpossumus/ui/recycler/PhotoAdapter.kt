package com.example.challengeandroidpossumus.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeandroidpossumus.R
import com.example.challengeandroidpossumus.data.model.Photo

class PhotoAdapter(private var listPhotos: List<Photo>): RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return PhotoViewHolder(layoutInflater.inflate(R.layout.item_photo, parent, false))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        var url = listPhotos[position].thumbnailUrl
        holder.bind(url)
    }

    override fun getItemCount(): Int = listPhotos.size

    fun addPhoto(photoList: List<Photo>){
        listPhotos = photoList
        notifyDataSetChanged()
    }
}