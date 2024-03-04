package com.eslamwaheed.domain.usecase

import com.eslamwaheed.domain.repo.MoviesRepo
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val moviesRepo: MoviesRepo) {
    suspend operator fun invoke(id: Int) = moviesRepo.getMovieDetails(id)
}