package com.example.challengeandroidpossumus.domain

import com.example.challengeandroidpossumus.data.Repository
import com.example.challengeandroidpossumus.data.model.Album
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(var albumRepo: Repository) {
    suspend operator fun invoke(): List<Album>? = albumRepo.getAlbumes()
}