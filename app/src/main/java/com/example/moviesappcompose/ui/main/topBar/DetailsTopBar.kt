package com.example.moviesappcompose.ui.main.topBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.moviesappcompose.R

@Composable
fun DetailsTopBar(name: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.arrow_back),
            contentDescription = name,
            colorFilter = ColorFilter.tint(color = Color.White),
            modifier = Modifier
                .clickable(
                    onClick = {
                        onClick.invoke()
                    }
                )
        )
        Text(
            text = name,
            modifier = Modifier
                .padding(start = 20.dp)
        )
    }
}
