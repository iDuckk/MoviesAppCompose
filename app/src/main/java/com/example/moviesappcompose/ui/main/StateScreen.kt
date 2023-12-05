package com.example.moviesappcompose.ui.main

import com.example.moviesappcompose.data.models.Film

sealed class StateScreen
class MainTopBarState() : StateScreen()
class DetailsTopBarState(val film: Film) : StateScreen()
