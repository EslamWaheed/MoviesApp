package com.eslamwaheed.data.mapper

import com.eslamwaheed.data.model.moviedetails.MovieDetailsResponse
import com.eslamwaheed.domain.model.moviedetails.MovieDetails
import javax.inject.Inject

class MovieDetailsMapper @Inject constructor() : Mapper<MovieDetailsResponse, MovieDetails> {
    override fun invoke(data: MovieDetailsResponse): MovieDetails {
        return with(data) {
            MovieDetails(
                title = title,
                releaseDate = releaseDate,
                posterImage = posterPath,
                overview = overview
            )
        }
    }
}