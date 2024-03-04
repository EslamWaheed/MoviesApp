package com.eslamwaheed.moviesapp.ui.moviedetails.viewmodel

import androidx.lifecycle.ViewModel
import com.eslamwaheed.domain.usecase.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) :
    ContainerHost<MovieDetailsState, MovieDetailsSideEffect>, ViewModel() {
    override val container: Container<MovieDetailsState, MovieDetailsSideEffect> = container(
        MovieDetailsState()
    )

    fun getMovieDetails(id: Int) = intent {
        reduce { state.copy(isLoading = true) }
        getMovieDetailsUseCase.invoke(id).fold(
            {
                reduce { state.copy(movieDetails = it) }
            },
            {
                //handel error
            }
        )
        reduce { state.copy(isLoading = false) }
    }

    fun onBackPressed() = intent {
        postSideEffect(MovieDetailsSideEffect.NavigateBack)
    }
}