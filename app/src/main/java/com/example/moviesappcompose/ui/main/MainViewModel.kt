package com.example.moviesappcompose.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesappcompose.domain.useCase.GetMovieListUseCase
import com.example.moviesappcompose.utils.ResultOf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMovieList: GetMovieListUseCase
): ViewModel() {

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getMovieList.invoke()) {
                is ResultOf.Failure -> {
                    if (result.throwable == null) {
                        Log.e("TAG", "getMovies: ${result.message}")
                    } else {
                        Log.e("TAG", "getMovies: ", result.throwable)
                    }
                }
                is ResultOf.Success -> {
                    result.value.films.forEach {
                        Log.d("TAG", "getMovies: ${it.name}")
                    }
                }
            }
        }
    }
}