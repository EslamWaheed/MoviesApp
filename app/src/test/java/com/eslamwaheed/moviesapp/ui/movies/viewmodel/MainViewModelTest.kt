package com.eslamwaheed.moviesapp.ui.movies.viewmodel

import com.appmattus.kotlinfixture.decorator.nullability.NeverNullStrategy
import com.appmattus.kotlinfixture.decorator.nullability.nullabilityStrategy
import com.appmattus.kotlinfixture.decorator.optional.optionalStrategy
import com.appmattus.kotlinfixture.kotlinFixture
import com.eslamwaheed.domain.model.nowplaying.NowPlaying
import com.eslamwaheed.domain.usecase.GetNowPlayingListUseCase
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
class MainViewModelTest {
    private val fixture = kotlinFixture {
        nullabilityStrategy(NeverNullStrategy)
        optionalStrategy { NeverNullStrategy }
        repeatCount { 2 }
    }

    @MockK
    private lateinit var getNowPlayingListUseCase: GetNowPlayingListUseCase

    private lateinit var classUnderTest: MainViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        classUnderTest = MainViewModel(getNowPlayingListUseCase)
    }

    @Test
    fun `init view model with a success of getNowPlayingListUseCase then reduce now playing list`() =
        runTest {
            val initState = MainState()

            val nowPlayingList: List<NowPlaying> = fixture()

            val result = Result.success(nowPlayingList)

            coEvery { getNowPlayingListUseCase.invoke() } returns result

            classUnderTest.test(this, initState) {
                runOnCreate()
                expectInitialState()

                expectState(
                    initState.copy(
                        isLoading = true
                    )
                )

                expectState(
                    initState.copy(
                        isLoading = false,
                        nowPlayingList = nowPlayingList
                    )
                )
            }
        }

    @Test
    fun `onPosterClicked post side effect NavigateToMovieDetails`() = runTest {
        val initState = MainState()

        val posterID: Int = fixture()

        classUnderTest.test(this, initState) {

            expectInitialState()

            containerHost.onPosterClicked(posterID)

            expectSideEffect(MainSideEffect.NavigateToMovieDetails(posterID))
        }
    }
}