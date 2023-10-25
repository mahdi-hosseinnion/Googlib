package com.ssmmhh.googlib

import com.ssmmhh.googlib.data.GoogleBooksApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceLocator {
    fun createRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun createBookApiService(): GoogleBooksApiService {
        return createRetrofitInstance().create(GoogleBooksApiService::class.java)
    }
}