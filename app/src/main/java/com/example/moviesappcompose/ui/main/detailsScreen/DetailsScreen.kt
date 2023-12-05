package com.example.moviesappcompose.ui.main.detailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.moviesappcompose.R
import com.example.moviesappcompose.data.models.Film

@Composable
fun DetailsScreen(
    innerPadding: PaddingValues,
    film: Film
) {
    Column(
        modifier = Modifier
            .background(color = Color.Black)
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        Row {
            if (film.image_url.isNullOrEmpty()) {
                Image(
                    painter = painterResource(R.drawable.empty_img),
                    contentDescription = film.localized_name,
                    modifier = Modifier
                        .padding(10.dp)
                )
            } else {
                AsyncImage(
                    model = "https://st.kp.yandex.net/images/film_iphone/${film.image_url.toUri().lastPathSegment}",
                    contentDescription = film.localized_name,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }

            Column {
                Text(
                    text = film.name,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                )

                Row(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Год: ",
                        color = Color.White,
                    )

                    Text(
                        text = film.year.toString(),
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Рейтинг: ",
                        color = Color.White

                    )

                    Text(
                        text = film.rating.toString(),
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }
            }





        }
        val desc = if (film.description.isNullOrEmpty()) "" else film.description
        Text(
            text = desc,
            color = Color.White,
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
        )
    }
}