package com.example.challengeandroidpossumus.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.challengeandroidpossumus.R
import com.example.challengeandroidpossumus.databinding.ActivityAlbumBinding
import com.example.challengeandroidpossumus.ui.viewmodel.PhotoViewModel

class AlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlbumBinding
    private val albumViewModel: PhotoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        albumViewModel.onCreateAlbums()
    }
}