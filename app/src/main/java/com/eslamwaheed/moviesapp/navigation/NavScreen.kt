package com.eslamwaheed.moviesapp.navigation

import androidx.compose.runtime.Immutable

@Immutable
sealed class NavScreen(val route: String) {
    data object Movies : NavScreen("Movies")

    data object MovieDetails : NavScreen("MovieDetails") {

        const val routeWithArgument: String = "MovieDetails/{movieId}"

        const val argument0: String = "movieId"
    }
}