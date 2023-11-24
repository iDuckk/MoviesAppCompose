package com.example.moviesappcompose.domain.repository

import com.example.moviesappcompose.data.models.Movie
import com.example.moviesappcompose.utils.ResultOf

interface MovieRepository {
    suspend fun getMovies(): ResultOf<Movie>
}