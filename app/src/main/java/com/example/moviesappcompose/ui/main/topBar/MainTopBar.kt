package com.example.moviesappcompose.ui.main.topBar

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.moviesappcompose.R

@Composable
fun MainTopBar() {
    Text(text = stringResource(R.string.app_bar_name))
}
