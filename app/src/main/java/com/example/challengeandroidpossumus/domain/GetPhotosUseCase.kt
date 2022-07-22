package com.example.challengeandroidpossumus.domain

import com.example.challengeandroidpossumus.data.PhotoRepository
import com.example.challengeandroidpossumus.data.model.Photo
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(var photoRepo: PhotoRepository) {

    suspend operator fun invoke(): List<Photo>? = photoRepo.getPhotos()
}