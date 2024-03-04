package com.eslamwaheed.moviesapp.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.eslamwaheed.moviesapp.navigation.NavScreen
import com.eslamwaheed.moviesapp.ui.moviedetails.view.MovieDetailsScreen
import com.eslamwaheed.moviesapp.ui.movies.view.MovieScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreen.Movies.route) {
        composable(
            route = NavScreen.Movies.route,
            arguments = emptyList()
        ) {
            MovieScreen(navController)
        }
        composable(
            route = NavScreen.MovieDetails.routeWithArgument,
            arguments = listOf(
                navArgument(NavScreen.MovieDetails.argument0) { type = NavType.IntType }
            )
        ) { backStackEntry ->

            val posterId = backStackEntry.arguments?.getInt(NavScreen.MovieDetails.argument0)
                ?: return@composable
            MovieDetailsScreen(navController, posterId)
        }
    }
}