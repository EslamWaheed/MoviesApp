package com.eslamwaheed.moviesapp.ui.movies.viewmodel

sealed class MainSideEffect {
    data class NavigateToMovieDetails(val id: Int) : MainSideEffect()
}