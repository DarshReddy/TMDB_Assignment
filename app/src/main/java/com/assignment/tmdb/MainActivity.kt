package com.assignment.tmdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.assignment.tmdb.ui.theme.TMDBTheme
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.annotations.Async

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TMDBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MoviesGrid(Modifier.padding(innerPadding), mainViewModel)
                }
            }
        }
    }
}

@Composable
fun MoviesGrid(
    modifier: Modifier,
    mainViewModel: MainViewModel
) {
    val topRatedMovies = mainViewModel.topRatedMovies.collectAsState()

    LaunchedEffect(Unit) {
        mainViewModel.getTopRatedMovies()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.padding(horizontal = 16.dp),
        content = {
            items(topRatedMovies.value.size) { index ->
                topRatedMovies.value[index].let { movie ->
                    val strokeColor = when {
                        movie.voteAverage > 8 -> Color.Green
                        movie.voteAverage > 5 -> Color.Yellow
                        else -> Color.Red
                    }
                    Column {
                        Box(
                            contentAlignment = Alignment.BottomStart
                        ) {
                            AsyncImage(
                                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                                model = movie.imageUrl,
                                contentDescription = movie.name
                            )
                            Box(
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    strokeWidth = 2.dp,
                                    trackColor = Color.LightGray,
                                    color = strokeColor,
                                    progress = { movie.voteAverage / 10 }
                                )
                                Text(
                                    text = movie.voteAverage.toString(),
                                    color = Color.Black
                                )
                            }

                        }
                        Text(
                            text = movie.name,
                            color = Color.Black
                        )
                        Text(
                            text = movie.airedYear,
                            color = Color.Blue
                        )
                    }
                }
            }
        }
    )
}


