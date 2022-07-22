package com.example.challengeandroidpossumus.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengeandroidpossumus.data.model.Photo
import com.example.challengeandroidpossumus.domain.GetPhotosUseCase
import kotlinx.coroutines.launch

class PhotoViewModel(): ViewModel() {
    var photoLiveData = MutableLiveData<List<Photo>>()
    var getPhotosUseCase = GetPhotosUseCase()

    fun onCreate(){
        viewModelScope.launch {
            //Se instancia un Caso de Uso para iniciar el consumo de la API.
            var response = getPhotosUseCase()

            if(!response.isNullOrEmpty()){
                photoLiveData.postValue(response!!)
            }
        }
    }
}