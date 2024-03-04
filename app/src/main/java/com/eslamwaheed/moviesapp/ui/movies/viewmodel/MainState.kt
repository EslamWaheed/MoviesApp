package com.eslamwaheed.moviesapp.ui.movies.viewmodel

import com.eslamwaheed.domain.model.nowplaying.NowPlaying

data class MainState(
    val isLoading: Boolean = false,
    val nowPlayingList: List<NowPlaying> = emptyList()
)
