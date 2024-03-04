package com.eslamwaheed.data.mapper

import com.eslamwaheed.data.model.nowplaying.NowPlayingResponse
import com.eslamwaheed.domain.model.nowplaying.NowPlaying
import javax.inject.Inject

@JvmSuppressWildcards
class NowPlayingMapper @Inject constructor() :
    Mapper<NowPlayingResponse, @JvmSuppressWildcards List<NowPlaying>> {
    override fun invoke(data: NowPlayingResponse): List<NowPlaying> {
        return with(data.results) {
            map {
                with(it) {
                    NowPlaying(
                        id = id,
                        title = title,
                        releaseDate = releaseDate,
                        posterImage = posterPath
                    )
                }
            }
        }
    }
}