package com.example.challengeandroidpossumus.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengeandroidpossumus.data.model.Album
import com.example.challengeandroidpossumus.data.model.Photo
import com.example.challengeandroidpossumus.domain.GetAlbumsUseCase
import com.example.challengeandroidpossumus.domain.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    var getPhotosUseCase: GetPhotosUseCase,
    var getAlbumsUseCase: GetAlbumsUseCase
): ViewModel() {
    var photoLiveData = MutableLiveData<List<Photo>>()
    var albumLiveData = MutableLiveData<List<Album>>()

    fun onCreatePhotos(){
        viewModelScope.launch {
            //Se instancia un Caso de Uso para iniciar el consumo de la API.
            var response = getPhotosUseCase()

            if(!response.isNullOrEmpty()){
                photoLiveData.postValue(response!!)
            }
        }
    }

    fun onCreateAlbums(){
        viewModelScope.launch {
            var response = getAlbumsUseCase()

            if(!response.isNullOrEmpty()){
                albumLiveData.postValue(response!!)
            }
        }
    }
}