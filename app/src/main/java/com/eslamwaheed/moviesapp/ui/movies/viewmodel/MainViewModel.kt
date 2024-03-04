package com.eslamwaheed.moviesapp.ui.movies.viewmodel

import androidx.lifecycle.ViewModel
import com.eslamwaheed.domain.usecase.GetNowPlayingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNowPlayingListUseCase: GetNowPlayingListUseCase
) : ContainerHost<MainState, MainSideEffect>, ViewModel() {
    override val container: Container<MainState, MainSideEffect> =
        container(initialState = MainState()) {
            getNowPlayingList()
        }

    private fun getNowPlayingList() = intent {
        reduce { state.copy(isLoading = true) }
        getNowPlayingListUseCase.invoke().fold(
            {
                reduce { state.copy(nowPlayingList = it) }
            },
            {
                //handel error
            }
        )
        reduce { state.copy(isLoading = false) }
    }

    fun onPosterClicked(id: Int) = intent {
        postSideEffect(MainSideEffect.NavigateToMovieDetails(id))
    }
}