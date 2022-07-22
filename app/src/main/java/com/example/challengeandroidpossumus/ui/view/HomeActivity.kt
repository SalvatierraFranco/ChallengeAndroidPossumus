package com.example.challengeandroidpossumus.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challengeandroidpossumus.R
import com.example.challengeandroidpossumus.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setPhotosList()
    }

    private fun setPhotosList() {
        binding.btnPhotos.setOnClickListener {
            var intentPhotos = Intent(it.context, MainActivity::class.java)
            startActivity(intentPhotos)
        }
    }
}