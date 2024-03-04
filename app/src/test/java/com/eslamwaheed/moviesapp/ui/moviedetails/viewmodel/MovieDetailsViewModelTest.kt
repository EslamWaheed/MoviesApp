package com.eslamwaheed.moviesapp.ui.moviedetails.viewmodel

import com.appmattus.kotlinfixture.decorator.nullability.NeverNullStrategy
import com.appmattus.kotlinfixture.decorator.nullability.nullabilityStrategy
import com.appmattus.kotlinfixture.decorator.optional.optionalStrategy
import com.appmattus.kotlinfixture.kotlinFixture
import com.eslamwaheed.domain.model.moviedetails.MovieDetails
import com.eslamwaheed.domain.usecase.GetMovieDetailsUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.orbitmvi.orbit.test.test

@RunWith(JUnit4::class)
class MovieDetailsViewModelTest {
    private val fixture = kotlinFixture {
        nullabilityStrategy(NeverNullStrategy)
        optionalStrategy { NeverNullStrategy }
        repeatCount { 2 }
    }

    @MockK
    private lateinit var getMovieDetailsUseCase: GetMovieDetailsUseCase

    private lateinit var classUnderTest: MovieDetailsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        classUnderTest = MovieDetailsViewModel(getMovieDetailsUseCase)
    }

    @Test
    fun `getMovieDetails when success reduce movie details`() = runTest {
        val initState = MovieDetailsState()

        val movieDetails: MovieDetails = fixture()

        val movieID: Int = fixture()

        coEvery { getMovieDetailsUseCase.invoke(movieID) } returns Result.success(movieDetails)

        classUnderTest.test(this, initState) {
            expectInitialState()

            containerHost.getMovieDetails(movieID)

            expectState(initState.copy(isLoading = true))

            expectState(initState.copy(movieDetails = movieDetails))
        }
    }

    @Test
    fun `onBackPressed post side effect NavigateBack`() = runTest {
        val initState = MovieDetailsState()

        classUnderTest.test(this, initState) {
            expectInitialState()

            containerHost.onBackPressed()

            expectSideEffect(MovieDetailsSideEffect.NavigateBack)
        }
    }
}