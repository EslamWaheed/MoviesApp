package com.eslamwaheed.moviesapp.di

import com.eslamwaheed.data.repo.MovieListsRepoImpl
import com.eslamwaheed.domain.repo.MovieListsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {
    @Binds
    fun bindsMovieListsRepoImpl(movieListsRepoImpl: MovieListsRepoImpl): MovieListsRepo
}