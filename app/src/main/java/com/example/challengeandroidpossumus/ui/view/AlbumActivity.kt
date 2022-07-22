package com.example.challengeandroidpossumus.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengeandroidpossumus.data.model.Providers
import com.example.challengeandroidpossumus.databinding.ActivityAlbumBinding
import com.example.challengeandroidpossumus.ui.recycler.AlbumAdapter
import com.example.challengeandroidpossumus.ui.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlbumBinding
    private lateinit var albumAdapter: AlbumAdapter
    private val albumViewModel: ViewModel by viewModels()
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        albumViewModel.onCreateAlbums()

        layoutManager = LinearLayoutManager(this)
        binding.rvAlbumes.layoutManager = layoutManager

        albumViewModel.albumLiveData.observe(this, Observer { listaAlbumes ->
            albumAdapter.addAlbum(listaAlbumes)
        })

        initUI()
    }

    private fun initUI() {
        albumAdapter = AlbumAdapter(Providers.albumes)
        binding.rvAlbumes.adapter = albumAdapter
    }
}