package com.eslamwaheed.domain.usecase

import com.eslamwaheed.domain.repo.MovieListsRepo
import javax.inject.Inject

class GetNowPlayingList @Inject constructor(private val movieListsRepo: MovieListsRepo) {
    suspend operator fun invoke() = movieListsRepo.getNowPlaying()
}