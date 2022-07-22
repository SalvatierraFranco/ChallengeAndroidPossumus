package com.example.challengeandroidpossumus.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeandroidpossumus.R
import com.example.challengeandroidpossumus.data.model.Album

class AlbumAdapter(private var listAlbumes: List<Album>): RecyclerView.Adapter<AlbumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return AlbumViewHolder(layoutInflater.inflate(R.layout.item_albumes, parent, false))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        var title = listAlbumes[position].title
        var userId = listAlbumes[position].userId
        holder.bind(title, userId)
    }

    override fun getItemCount(): Int = listAlbumes.size

    fun addAlbum(albumLista: List<Album>){
        listAlbumes = albumLista
        notifyDataSetChanged()
    }
}