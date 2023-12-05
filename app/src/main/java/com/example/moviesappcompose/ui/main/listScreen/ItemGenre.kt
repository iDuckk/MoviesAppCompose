package com.example.moviesappcompose.ui.main.listScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.moviesappcompose.ui.theme.Blue
import com.example.moviesappcompose.ui.theme.Dark_gray

@Composable
fun ItemGenre(
    genre: String,
    buttonColor: MutableState<String>,
    onClick: (String) -> Unit
    ) {
    Box (
        modifier = Modifier
            .clickable(
                onClick = {
                    buttonColor.value = genre
                    onClick.invoke(genre)
                })
    ) {
        Text(
            text = genre,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .padding(top = 2.dp, start = 2.dp)
                .height(40.dp)
                .width(130.dp)
                .clip(shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                .background(
                    color = if (buttonColor.value == genre) Blue else Dark_gray,
                    shape = RectangleShape
                )
                .wrapContentSize()
        )

    }
}