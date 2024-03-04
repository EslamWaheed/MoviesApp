package com.eslamwaheed.domain.usecase

import com.eslamwaheed.domain.repo.MoviesRepo
import javax.inject.Inject

class GetNowPlayingListUseCase @Inject constructor(private val moviesRepo: MoviesRepo) {
    suspend operator fun invoke() = moviesRepo.getNowPlaying()
}