package com.example.challengeandroidpossumus.ui.recycler

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeandroidpossumus.databinding.ItemPhotoBinding
import com.example.challengeandroidpossumus.ui.view.PhotoDetailsActivity
import com.squareup.picasso.Picasso

class PhotoViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var binding = ItemPhotoBinding.bind(view)

    fun bind(url: String){
        Picasso.get().load(url).into(binding.ivPhoto)
    }

    //Código para poder hacer click en un elemento del RecyclerView y poder acceder a los detalles
    init {
        view.setOnClickListener{
            var position = adapterPosition
            var intent = Intent(it.context, PhotoDetailsActivity::class.java).apply {
                putExtra("id", position)
            }
            ContextCompat.startActivity(it.context, intent, null)
        }
    }
}