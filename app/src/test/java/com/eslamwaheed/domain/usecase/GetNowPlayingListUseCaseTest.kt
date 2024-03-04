package com.eslamwaheed.domain.usecase

import com.appmattus.kotlinfixture.decorator.nullability.NeverNullStrategy
import com.appmattus.kotlinfixture.decorator.nullability.nullabilityStrategy
import com.appmattus.kotlinfixture.decorator.optional.optionalStrategy
import com.appmattus.kotlinfixture.kotlinFixture
import com.eslamwaheed.domain.model.nowplaying.NowPlaying
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
class GetNowPlayingListUseCaseTest{
    private val fixture = kotlinFixture {
        nullabilityStrategy(NeverNullStrategy)
        optionalStrategy { NeverNullStrategy }
        repeatCount { 2 }
    }

    @MockK
    private lateinit var moviesRepo: MoviesRepo

    private lateinit var classUnderTest: GetNowPlayingListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        classUnderTest = GetNowPlayingListUseCase(moviesRepo)
    }

    @Test
    fun `invoke when success then return success of List of NowPlaying`() = runTest {
        val listOfNowPlaying: List<NowPlaying> = fixture()

        val expectedResult = Result.success(listOfNowPlaying)

        coEvery { moviesRepo.getNowPlaying() } returns expectedResult

        val result = classUnderTest.invoke()

        Assert.assertEquals(expectedResult, result)
    }
}