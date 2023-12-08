package com.example.moviesappcompose.data.retrofit

import com.example.moviesappcompose.data.models.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("films.json")
    suspend fun getAllData(): Response<Movie>
}