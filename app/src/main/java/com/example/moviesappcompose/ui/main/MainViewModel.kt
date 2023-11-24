package com.example.moviesappcompose.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesappcompose.domain.useCase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMovieList: GetMovieListUseCase
): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val list = getMovieList.invoke()
        }
    }

}