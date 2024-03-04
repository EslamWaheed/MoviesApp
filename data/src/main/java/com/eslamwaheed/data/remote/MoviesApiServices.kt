package com.eslamwaheed.data.remote

import com.eslamwaheed.data.model.moviedetails.MovieDetailsResponse
import com.eslamwaheed.data.model.nowplaying.NowPlayingResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApiServices {
    @GET("discover/movie")
    suspend fun getNowPlaying(): Result<NowPlayingResponse>

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(@Path("movieId") customerId: Int): Result<MovieDetailsResponse>
}