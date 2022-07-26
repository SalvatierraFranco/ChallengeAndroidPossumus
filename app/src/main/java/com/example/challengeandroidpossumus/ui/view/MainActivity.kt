package com.example.challengeandroidpossumus.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeandroidpossumus.data.model.Providers
import com.example.challengeandroidpossumus.databinding.ActivityMainBinding
import com.example.challengeandroidpossumus.ui.recycler.PhotoAdapter
import com.example.challengeandroidpossumus.ui.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val photoViewModel: ViewModel by viewModels()
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Se llama al método onCreate() para iniciar el consumo de la API
        photoViewModel.onCreatePhotos()

        layoutManager = LinearLayoutManager(this)
        binding.rvPhotos.layoutManager = layoutManager
        
        photoViewModel.photoLiveData.observe(this, Observer { photosList ->
            photoAdapter.addPhoto(photosList)
        })

        initUi()
    }

    //Se configura RecyclerView para que muestre los datos en 3 columnas
    private fun initUi() {
        GridLayoutManager(this, 3, RecyclerView.VERTICAL, false)
            .apply { binding.rvPhotos.layoutManager = this }
        photoAdapter = PhotoAdapter(Providers.photos)
        //Adapter de recyclerView recibe una instancia de PhotoAdapter con
        // los datos obtenidos de la API
        binding.rvPhotos.adapter = photoAdapter
    }
}