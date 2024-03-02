package com.eslamwaheed.data.di

import com.eslamwaheed.data.mapper.Mapper
import com.eslamwaheed.data.mapper.NowPlayingMapper
import com.eslamwaheed.data.model.nowplaying.NowPlayingResponse
import com.eslamwaheed.domain.model.nowplaying.NowPlaying
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MapperModule {

    @Binds
    fun bindsNowPlayingMapper(nowPlayingMapper: NowPlayingMapper): Mapper<NowPlayingResponse, List<NowPlaying>>
}