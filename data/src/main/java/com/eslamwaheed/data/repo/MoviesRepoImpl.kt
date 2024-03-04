package com.eslamwaheed.data.repo

import com.eslamwaheed.data.mapper.Mapper
import com.eslamwaheed.data.model.moviedetails.MovieDetailsResponse
import com.eslamwaheed.data.model.nowplaying.NowPlayingResponse
import com.eslamwaheed.data.remote.MoviesApiServices
import com.eslamwaheed.domain.model.moviedetails.MovieDetails
import com.eslamwaheed.domain.model.nowplaying.NowPlaying
import com.eslamwaheed.domain.repo.MoviesRepo
import javax.inject.Inject

class MoviesRepoImpl @Inject constructor(
    private val moviesApiServices: MoviesApiServices,
    private val nowPlayingMapper: Mapper<NowPlayingResponse, List<NowPlaying>>,
    private val movieDetailsMapper: Mapper<MovieDetailsResponse, MovieDetails>
) : MoviesRepo {
    override suspend fun getNowPlaying(): Result<List<NowPlaying>> {
        return moviesApiServices.getNowPlaying().map {
            nowPlayingMapper(it)
        }
    }

    override suspend fun getMovieDetails(id: Int): Result<MovieDetails> {
        return moviesApiServices.getMovieDetails(id).map {
            movieDetailsMapper(it)
        }
    }
}