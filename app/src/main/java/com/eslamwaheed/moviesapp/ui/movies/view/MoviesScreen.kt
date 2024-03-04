package com.eslamwaheed.moviesapp.ui.movies.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.eslamwaheed.data.remote.API
import com.eslamwaheed.domain.model.nowplaying.NowPlaying
import com.eslamwaheed.moviesapp.navigation.NavScreen
import com.eslamwaheed.moviesapp.ui.movies.viewmodel.MainSideEffect
import com.eslamwaheed.moviesapp.ui.movies.viewmodel.MainViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MovieScreen(
    navController: NavController
) {
    val viewModel: MainViewModel = hiltViewModel()

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect {
        when (it) {
            is MainSideEffect.NavigateToMovieDetails -> {
                navController.navigate("${NavScreen.MovieDetails.route}/${it.id}")
            }
        }
    }

    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
        items(state.nowPlayingList) { movie ->
            MoviePoster(
                movie = movie,
                selectPoster = {
                    viewModel.onPosterClicked(it)
                }
            )
        }
    }
}

@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    movie: NowPlaying,
    selectPoster: ((Int) -> Unit)
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(290.dp)
            .clickable(
                onClick = {
                    selectPoster.invoke(movie.id)
                }
            )
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                model = API.BASE_POSTER_PATH.plus(movie.posterImage),
                contentDescription = null
            )
            Text(
                text = movie.title,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(0.85f)
                    .padding(horizontal = 8.dp)
            )
        }
    }
}