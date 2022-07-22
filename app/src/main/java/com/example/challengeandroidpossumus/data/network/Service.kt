package com.example.challengeandroidpossumus.data.network

import com.example.challengeandroidpossumus.data.model.Album
import com.example.challengeandroidpossumus.data.model.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Service @Inject constructor(var api: ApiClient) {

    suspend fun getPhotos(): List<Photo>?{
        //Se consume la API usando corrutina para no afectar el hilo principal de los procesos
        return withContext(Dispatchers.IO){
            var response = api.getAllPhotos()
            response.body()
        }
    }

    suspend fun getAlbumes(): List<Album>?{

        return withContext(Dispatchers.IO){
            var response = api.getAllAlbums()
            response.body()
        }
    }
}