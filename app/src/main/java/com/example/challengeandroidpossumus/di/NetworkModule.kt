package com.example.challengeandroidpossumus.di

import com.example.challengeandroidpossumus.data.network.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//Creo este módulo para proveer retrofit y ApiClient
@Module
@InstallIn(SingletonComponent::class) //Declaro alcance a nivel Aplicación
object NetworkModule {
    @Provides
    @Singleton //Declaro que solo se debe usar una instancia para ahorrar memoria
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }
}