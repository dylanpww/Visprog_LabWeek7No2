package com.example.labweek782.data.container

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.labweek782.data.service.MusicService

object RetrofitInstance {
    private const val BASE_URL = "https://theaudiodb.com/api/v1/json/123/"

    val api: MusicService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MusicService::class.java)
    }
}
