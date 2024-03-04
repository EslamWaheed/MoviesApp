package com.eslamwaheed.moviesapp.ui.moviedetails.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.eslamwaheed.data.remote.API
import com.eslamwaheed.moviesapp.R
import com.eslamwaheed.moviesapp.ui.custom.AppBarWithArrow
import com.eslamwaheed.moviesapp.ui.moviedetails.viewmodel.MovieDetailsSideEffect
import com.eslamwaheed.moviesapp.ui.moviedetails.viewmodel.MovieDetailsState
import com.eslamwaheed.moviesapp.ui.moviedetails.viewmodel.MovieDetailsViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MovieDetailsScreen(
    navController: NavHostController,
    posterId: Int
) {
    val viewModel: MovieDetailsViewModel = hiltViewModel()

    viewModel.getMovieDetails(posterId)

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect {
        when (it) {
            MovieDetailsSideEffect.NavigateBack -> {
                navController.popBackStack()
            }
        }
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
    ) {

        AppBarWithArrow(state.movieDetails?.title) {
            viewModel.onBackPressed()
        }

        MovieDetailHeader(state)

        MovieDetailSummary(state)

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun MovieDetailHeader(state: MovieDetailsState) {

    Column {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            model = API.BASE_POSTER_PATH.plus(state.movieDetails?.posterImage),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = state.movieDetails?.title ?: "",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = state.movieDetails?.releaseDate ?: "",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun MovieDetailSummary(
    state: MovieDetailsState
) {
    Column {
        Spacer(modifier = Modifier.height(23.dp))

        Text(
            text = stringResource(R.string.summary),
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = state.movieDetails?.overview ?: "",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))
    }
}