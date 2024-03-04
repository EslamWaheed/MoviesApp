package com.eslamwaheed.data.repo

import com.eslamwaheed.data.mapper.Mapper
import com.eslamwaheed.data.model.nowplaying.NowPlayingResponse
import com.eslamwaheed.data.remote.MoviesListApiServices
import com.eslamwaheed.domain.model.nowplaying.NowPlaying
import com.eslamwaheed.domain.repo.MovieListsRepo
import javax.inject.Inject

class MovieListsRepoImpl @Inject constructor(
    private val moviesListApiServices: MoviesListApiServices,
    private val nowPlayingMapper: Mapper<NowPlayingResponse, List<NowPlaying>>
) : MovieListsRepo {
    override suspend fun getNowPlaying(): Result<List<NowPlaying>> {
        return moviesListApiServices.getNowPlaying().map {
            nowPlayingMapper(it)
        }
    }
}