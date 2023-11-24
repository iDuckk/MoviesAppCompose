package com.example.moviesappcompose.data.repository

import android.util.Log
import com.example.moviesappcompose.data.models.Movie
import com.example.moviesappcompose.data.retrofit.ApiService
import com.example.moviesappcompose.domain.repository.MovieRepository
import com.example.moviesappcompose.utils.ResultOf
import javax.inject.Inject

class MovieRepositoryImpl@Inject constructor(
    private val api: ApiService
): MovieRepository {
    override suspend fun getMovies(): ResultOf<Movie> {
        TODO("Not yet implemented")
    }
}