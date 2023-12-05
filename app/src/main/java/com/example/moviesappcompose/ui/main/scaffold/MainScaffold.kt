package com.example.moviesappcompose.ui.main.scaffold

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridScopeMarker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.moviesappcompose.R
import com.example.moviesappcompose.ui.main.DetailsTopBarState
import com.example.moviesappcompose.ui.main.MainTopBarState
import com.example.moviesappcompose.ui.main.MainViewModel
import com.example.moviesappcompose.ui.main.StateScreen
import com.example.moviesappcompose.ui.main.detailsScreen.DetailsScreen
import com.example.moviesappcompose.ui.main.listScreen.MainList
import com.example.moviesappcompose.ui.main.topBar.DetailsTopBar
import com.example.moviesappcompose.ui.main.topBar.MainTopBar
import com.example.moviesappcompose.ui.theme.Gray_title
import kotlinx.coroutines.flow.MutableStateFlow

@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@LazyGridScopeMarker
fun MainScaffold(viewModel: MainViewModel) {

    val buttonColor = remember { mutableStateOf("") }
    val filmList = remember { mutableStateOf(viewModel.movies) }
    val stateTopBar = MutableStateFlow<StateScreen>(MainTopBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Gray_title,
                    titleContentColor = Color.White,
                ),
                title = {
                    when (val state = stateTopBar.collectAsState().value) {
                        is MainTopBarState -> MainTopBar()
                        is DetailsTopBarState -> DetailsTopBar(
                            name = state.film.localized_name,
                            onClick = {
                                stateTopBar.value = MainTopBarState()
                            }
                        )
                    }
                }
            )
        }
    )
    { innerPadding ->
        when (val state = stateTopBar.collectAsState().value) {
            is MainTopBarState -> {
                MainList(
                    innerPadding = innerPadding,
                    viewModel = viewModel,
                    buttonColor = buttonColor,
                    filmList = filmList,
                    itemFilmClick = { film ->
                        stateTopBar.value = DetailsTopBarState(film)
                    })
            }
            is DetailsTopBarState -> {
                DetailsScreen(innerPadding = innerPadding, film = state.film)
            }
        }
        
    }
}