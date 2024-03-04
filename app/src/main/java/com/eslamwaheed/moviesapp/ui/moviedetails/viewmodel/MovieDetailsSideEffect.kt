package com.eslamwaheed.moviesapp.ui.moviedetails.viewmodel

sealed class MovieDetailsSideEffect {
    data object NavigateBack : MovieDetailsSideEffect()
}