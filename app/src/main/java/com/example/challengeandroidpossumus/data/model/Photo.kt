package com.example.challengeandroidpossumus.data.model

//Creación de data class con las variables necesarias para almacenar
// los datos de los objetos de la API
data class Photo(
    var albumId: Int,
    var id: Int,
    var title: String,
    var url: String,
    var thumbnailUrl: String
)
