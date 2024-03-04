package com.eslamwaheed.moviesapp.ui.main.viewmodel

sealed class MainSideEffect {
    data class NavigateToMovieDetails(val id: Int) : MainSideEffect()
}