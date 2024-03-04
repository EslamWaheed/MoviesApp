package com.eslamwaheed.data.remote

import com.eslamwaheed.data.model.nowplaying.NowPlayingResponse
import retrofit2.http.GET

interface MoviesListApiServices {
    @GET("discover/movie")
    suspend fun getNowPlaying(): Result<NowPlayingResponse>
}