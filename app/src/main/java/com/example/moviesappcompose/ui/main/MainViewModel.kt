package com.example.moviesappcompose.ui.main

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesappcompose.domain.useCase.GetMovieListUseCase
import com.example.moviesappcompose.utils.ResultOf
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext private val application: Context,
    private val getMovieList: GetMovieListUseCase
): ViewModel() {

    val genres = mutableListOf<String>()

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getMovieList.invoke()) {
                is ResultOf.Failure -> {
                    if (result.throwable == null) {
                        if (result.code == 0) {
                            launch(Dispatchers.Main) {
                                Toast.makeText(application, "No internet connection", Toast.LENGTH_SHORT).show()
                            }
                        }
                        Log.e("TAG", "getMovies: ${result.message}")
                    } else {
                        Log.e("TAG", "getMovies: ", result.throwable)
                    }
                }
                is ResultOf.Success -> {
                    //Get genres
                    launch(Dispatchers.IO) {
                        result.value.films.forEach { film ->
                            genres.addAll(film.genres)
                        }
                    }
                    //Get list movies
                    launch(Dispatchers.IO) {
                        result.value.films
                    }
                }
            }
        }
    }
}