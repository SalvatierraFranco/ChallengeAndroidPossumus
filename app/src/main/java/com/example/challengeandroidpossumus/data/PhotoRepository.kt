package com.example.challengeandroidpossumus.data

import com.example.challengeandroidpossumus.data.model.Photo
import com.example.challengeandroidpossumus.data.model.PhotoProvider
import com.example.challengeandroidpossumus.data.network.PhotoService

class PhotoRepository {
    var api = PhotoService()

    suspend fun getPhotos(): List<Photo>?{
        var response = api.getPhotos()

        //Se guarda los objetos obtenidos en una lista propia no tener que
        // recurrir a la API reiteradas veces.
        if(response != null){
            PhotoProvider.photos = response
            println(response)
        }
        return response
    }
}