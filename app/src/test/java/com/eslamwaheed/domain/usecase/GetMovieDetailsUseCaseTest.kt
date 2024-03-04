package com.eslamwaheed.domain.usecase

import com.appmattus.kotlinfixture.decorator.nullability.NeverNullStrategy
import com.appmattus.kotlinfixture.decorator.nullability.nullabilityStrategy
import com.appmattus.kotlinfixture.decorator.optional.optionalStrategy
import com.appmattus.kotlinfixture.kotlinFixture
import com.eslamwaheed.domain.model.moviedetails.MovieDetails
import com.eslamwaheed.domain.repo.MoviesRepo
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetMovieDetailsUseCaseTest {
    private val fixture = kotlinFixture {
        nullabilityStrategy(NeverNullStrategy)
        optionalStrategy { NeverNullStrategy }
        repeatCount { 2 }
    }

    @MockK
    private lateinit var moviesRepo: MoviesRepo

    private lateinit var classUnderTest: GetMovieDetailsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        classUnderTest = GetMovieDetailsUseCase(moviesRepo)
    }

    @Test
    fun `invoke when success then return success of movieDetails`() = runTest {
        val movieDetails: MovieDetails = fixture()

        val movieID: Int = fixture()

        val expectedResult = Result.success(movieDetails)

        coEvery { moviesRepo.getMovieDetails(movieID) } returns expectedResult

        val result = classUnderTest.invoke(movieID)

        Assert.assertEquals(expectedResult, result)
    }
}