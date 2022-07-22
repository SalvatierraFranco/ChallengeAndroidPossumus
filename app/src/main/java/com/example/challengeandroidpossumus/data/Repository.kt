package com.example.challengeandroidpossumus.data

import com.example.challengeandroidpossumus.data.model.Album
import com.example.challengeandroidpossumus.data.model.Photo
import com.example.challengeandroidpossumus.data.model.Providers
import com.example.challengeandroidpossumus.data.network.Service
import javax.inject.Inject

class Repository @Inject constructor(var api: Service) {

    suspend fun getPhotos(): List<Photo>?{
        var responsePhotos = api.getPhotos()

        //Se guarda los objetos obtenidos en una lista propia no tener que
        // recurrir a la API reiteradas veces.
        if(responsePhotos != null){
            Providers.photos = responsePhotos
        }
        return responsePhotos
    }

    suspend fun getAlbumes(): List<Album>?{
        var responseAlbums = api.getAlbumes()

        if(responseAlbums != null){
            Providers.albumes = responseAlbums
        }
        return responseAlbums
    }
}