package com.example.moviesappcompose.data.repository

import android.content.Context
import com.example.moviesappcompose.data.models.Movie
import com.example.moviesappcompose.data.retrofit.ApiService
import com.example.moviesappcompose.domain.repository.MovieRepository
import com.example.moviesappcompose.utils.NetworkManagerConnection
import com.example.moviesappcompose.utils.ResultOf
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class MovieRepositoryImpl@Inject constructor(
    private val api: ApiService,
    @ApplicationContext private val context: Context
): MovieRepository {
    override suspend fun getMovies(): ResultOf<Movie> = coroutineScope {
        return@coroutineScope try {
            if(NetworkManagerConnection.invoke(context = context)) {
                val response = api.getAllData()
                if (response.isSuccessful) {
                    ResultOf.Success(value = response.body()!!)
                } else {
                    ResultOf.Failure(
                        message = response.message(),
                        code = response.code(),
                    )
                }
            } else {
                ResultOf.Failure(
                    message = "No internet connection",
                    code = 0
                )
            }
        } catch (e: Exception) {
            ResultOf.Failure(throwable = e)
        }
    }
}