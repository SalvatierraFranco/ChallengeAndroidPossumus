package com.example.challengeandroidpossumus.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.challengeandroidpossumus.R
import com.example.challengeandroidpossumus.databinding.ActivityMainBinding
import com.example.challengeandroidpossumus.ui.viewmodel.PhotoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val photoViewModel: PhotoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Se llama al método onCreate() para iniciar el consumo de la API
        photoViewModel.onCreate()
    }
}