package com.example.moviesappcompose.ui.main.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScopeMarker
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.moviesappcompose.R
import com.example.moviesappcompose.ui.main.DetailsTopBarState
import com.example.moviesappcompose.ui.main.MainTopBarState
import com.example.moviesappcompose.ui.main.MainViewModel
import com.example.moviesappcompose.ui.main.StateScreen
import com.example.moviesappcompose.ui.main.list.ItemFilm
import com.example.moviesappcompose.ui.main.list.ItemGenre
import com.example.moviesappcompose.ui.main.list.ItemTitle
import com.example.moviesappcompose.ui.main.topBar.DetailsTopBar
import com.example.moviesappcompose.ui.main.topBar.MainTopBar
import com.example.moviesappcompose.ui.theme.Gray_title
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@LazyGridScopeMarker
fun MainScaffold(viewModel: MainViewModel) {
    val buttonColor = remember { mutableStateOf("") }
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
                            name = state.name,
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
        LazyVerticalGrid(
            modifier = Modifier
                .background(color = Color.Black)
                .padding(innerPadding)
                .fillMaxSize(),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(3.dp),
            horizontalArrangement = Arrangement.spacedBy(3.dp),
            content = {
                /**
                 * Заголовок жанров
                 * */
                item(span = {
                    GridItemSpan(maxLineSpan)
                }) {
                    ItemTitle(title = stringResource(R.string.title_genre))
                }
                /**
                 * Список жанров
                 * */
                items(
                    items = viewModel.genres.distinct(),
                    span = {
                        GridItemSpan(maxLineSpan)
                    },
                    itemContent = { item ->
                        ItemGenre(
                            genre = item,
                            buttonColor = buttonColor
                        )
                    })
                /**
                 * Заголовок фильмов
                 * */
                item(span = {
                    GridItemSpan(maxLineSpan)
                }) {
                    ItemTitle(title = stringResource(R.string.title_film))
                }
                /**
                 * Список фильмов
                 * */
                items(
                    items = viewModel.movies,
                    span = {
                        GridItemSpan(1)
                    },
                    itemContent = { item ->
                        ItemFilm(
                            film = item,
                            onClick = {film ->
                                stateTopBar.value = DetailsTopBarState(film.localized_name)
                            }
                        )
                    })
            })
    }
}