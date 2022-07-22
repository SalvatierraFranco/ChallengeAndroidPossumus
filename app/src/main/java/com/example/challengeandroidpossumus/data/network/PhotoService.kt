package com.example.challengeandroidpossumus.data.network

import com.example.challengeandroidpossumus.core.RetrofitHelper
import com.example.challengeandroidpossumus.data.model.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotoService {
    suspend fun getPhotos(): List<Photo>?{

        var retrofit = RetrofitHelper.getRetrofit()

        //Se consume la API usando corrutina para no afectar el hilo principal de los procesos
        return withContext(Dispatchers.IO){
            var response = retrofit.create(PhotoApiClient::class.java).getAllPhotos()
            response.body()
        }
    }
}