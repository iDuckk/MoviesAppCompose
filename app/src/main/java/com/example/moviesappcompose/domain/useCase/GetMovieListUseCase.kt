package com.example.moviesappcompose.domain.useCase

import com.example.moviesappcompose.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieListUseCase@Inject constructor(private val repo : MovieRepository) {
    suspend operator fun invoke() = repo.getMovies()
}