package com.eslamwaheed.domain.repo

import com.eslamwaheed.domain.model.moviedetails.MovieDetails
import com.eslamwaheed.domain.model.nowplaying.NowPlaying

interface MoviesRepo {
    suspend fun getNowPlaying(): Result<List<NowPlaying>>

    suspend fun getMovieDetails(id:Int): Result<MovieDetails>
}