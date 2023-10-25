package com.ssmmhh.googlib.data

import retrofit2.http.GET
import retrofit2.http.Query


interface GoogleBooksApiService {
    @GET("books/v1/volumes")
    suspend fun listRepos(@Query("q") query: String?): VolumesResponse
}