package com.eslamwaheed.domain.repo

import com.eslamwaheed.domain.model.nowplaying.NowPlaying

interface MovieListsRepo {
    suspend fun getNowPlaying(): Result<List<NowPlaying>>
}