package com.example.moviesappcompose.ui.main

sealed class StateScreen
class MainTopBarState() : StateScreen()
class DetailsTopBarState(val name: String) : StateScreen()
