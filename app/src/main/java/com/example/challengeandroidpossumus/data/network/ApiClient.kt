package com.example.challengeandroidpossumus.data.network

import com.example.challengeandroidpossumus.data.model.Album
import com.example.challengeandroidpossumus.data.model.Photo
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("photos")
    suspend fun getAllPhotos(): Response<List<Photo>>

    @GET("albums")
    suspend fun getAllAlbums(): Response<List<Album>>
}