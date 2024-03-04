package com.eslamwaheed.moviesapp.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.eslamwaheed.data.remote.API
import com.eslamwaheed.data.remote.MoviesApiServices
import com.eslamwaheed.network.networkerrors.ResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(chuckerInterceptor: ChuckerInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().header(
                        "Authorization",
                        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5N2QwMGVjMmNlNzNkMTJlZDYwNWU2MGZmM2JiYThjYyIsInN1YiI6IjVhZWYxYTM3MGUwYTI2MWQ5NTAwNjBlMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ARsR2fL3kbY8ZFZwBEL-e7LFNnfjLg1eRABU1RrpseI"
                    ).build()
                )
            }.connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(chuckerInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesChucker(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor(context)
    }

    @Provides
    @Singleton
    fun providesResultCallAdapter(): CallAdapter.Factory {
        return ResultCallAdapterFactory()
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        resultCallAdapterFactory: ResultCallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(resultCallAdapterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun providesMoviesListApiServices(retrofit: Retrofit): MoviesApiServices {
        return retrofit.create(MoviesApiServices::class.java)
    }
}