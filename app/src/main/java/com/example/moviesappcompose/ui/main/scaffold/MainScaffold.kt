package com.example.moviesappcompose.ui.main.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.moviesappcompose.R
import com.example.moviesappcompose.ui.main.MainViewModel
import com.example.moviesappcompose.ui.theme.Black_transparent
import com.example.moviesappcompose.ui.theme.Dark_gray
import com.example.moviesappcompose.ui.theme.Gray_title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(viewModel: MainViewModel) {
//    var presses by remember { mutableIntStateOf(0) }


    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Gray_title,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(text = stringResource(R.string.app_bar_name))
                }
            )
        }
    )
    { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .padding(innerPadding),
        ) {
            item {
                Box(
                    modifier = Modifier
                        .padding(3.dp)
                        .fillParentMaxWidth()
                        .height(40.dp)
                        .clip(shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                ) {
                    Text(
                        text = stringResource(R.string.title_genre),
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Gray_title, shape = RectangleShape)
                            .wrapContentHeight(CenterVertically)
                            .wrapContentWidth(CenterHorizontally)
                    )
                }
            }

            items(items = viewModel.genres.distinct(), itemContent = { item ->
                Box(
                    modifier = Modifier
                        .padding(start = 3.dp, top = 3.dp)
                        .width(130.dp)
                        .height(40.dp)
                        .clip(shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                ) {
                    Text(
                        text = item,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Dark_gray, shape = RectangleShape)
                            .wrapContentHeight(CenterVertically)
                            .wrapContentWidth(CenterHorizontally)
                    )
                }

            }
            )
        }
    }
}