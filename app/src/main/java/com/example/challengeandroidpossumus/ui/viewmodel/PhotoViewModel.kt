package com.example.challengeandroidpossumus.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengeandroidpossumus.data.model.Photo
import com.example.challengeandroidpossumus.domain.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    var getPhotosUseCase: GetPhotosUseCase
): ViewModel() {
    var photoLiveData = MutableLiveData<List<Photo>>()

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