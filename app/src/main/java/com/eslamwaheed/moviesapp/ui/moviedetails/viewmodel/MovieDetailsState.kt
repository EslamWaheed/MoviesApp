package com.eslamwaheed.moviesapp.ui.moviedetails.viewmodel

import com.eslamwaheed.domain.model.moviedetails.MovieDetails

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val movieDetails: MovieDetails? = null
)
