package com.example.moviesappcompose.ui.main.listScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.moviesappcompose.R
import com.example.moviesappcompose.data.models.Film
import com.example.moviesappcompose.ui.theme.Black_transparent

@Composable
@Preview
fun ItemFilm(
    film: Film,
    onClick: (Film) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .clickable(
                onClick = {
                    onClick.invoke(film)
                }),
        content = {
            Box(
                modifier = Modifier
                    .width(130.dp)
                    .align(Alignment.CenterHorizontally)
                    .wrapContentSize(),
                content = {
                            if (film.image_url.isNullOrEmpty()) {
                                Image(
                                    painter = painterResource(R.drawable.empty_img),
                                    contentDescription = film.localized_name,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .clip(shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                                )
                            } else {
                                AsyncImage(
                                    model = "https://st.kp.yandex.net/images/film_iphone/${film.image_url.toUri().lastPathSegment}",
                                    contentDescription = film.localized_name,
                                    contentScale = ContentScale.Inside,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .clip(shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                                )
                            }
                    Text(
                        text = film.localized_name,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 5.dp, end = 5.dp)
                            .height(40.dp)
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .background(color = Black_transparent)

                    )
                }
            )
        }
    )
}