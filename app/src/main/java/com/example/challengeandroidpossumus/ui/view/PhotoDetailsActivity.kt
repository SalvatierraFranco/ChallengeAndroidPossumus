package com.example.challengeandroidpossumus.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challengeandroidpossumus.R
import com.example.challengeandroidpossumus.data.model.PhotoProvider
import com.example.challengeandroidpossumus.databinding.ActivityPhotoDetailsBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhotoDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_details)

        binding = ActivityPhotoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id = getExtras()
        initUI(id)
    }

    private fun getExtras(): Int{
        var bundle = intent.extras
        var number = bundle!!.getInt("id")

        return number
    }

    private fun initUI(id: Int) {
        binding.tvAlbumId.text = PhotoProvider.photos[id].albumId.toString()
        binding.tvTitle.text = PhotoProvider.photos[id].title
        Picasso.get().load(PhotoProvider.photos[id].url).into(binding.ivUrlPhoto)
    }
}