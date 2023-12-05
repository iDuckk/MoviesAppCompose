package com.example.moviesappcompose.ui.main.listScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.moviesappcompose.R
import com.example.moviesappcompose.data.models.Film
import com.example.moviesappcompose.ui.main.MainViewModel

@Composable
fun MainList(
    innerPadding: PaddingValues,
    viewModel: MainViewModel,
    buttonColor: MutableState<String>,
    filmList: MutableState<MutableList<Film>>,
    itemFilmClick: (Film) -> Unit
    ) {
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
                        buttonColor = buttonColor,
                        onClick = { genre ->
                            filmList.value = viewModel.movies.filter { it.genres.contains(genre) }.toMutableList()
                        }
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
                items = filmList.value,
                span = {
                    GridItemSpan(1)
                },
                itemContent = { item ->
                    ItemFilm(
                        film = item,
                        onClick = { film ->
                            itemFilmClick.invoke(film)
                        }
                    )
                })
        })
}