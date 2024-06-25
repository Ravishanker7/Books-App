package com.example.gamesapi.data


import com.example.gamesapi.Domain.repositery.FreeGamesRepositery
import com.example.gamesapi.core.utils.Constants.BASEURL
import com.example.gamesapi.data.remote.dto.GamesApi
import com.example.gamesapi.data.repositery.FreeGamesRepositeryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance()= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASEURL)
        .build()
    @Provides
    @Singleton
    fun provideFreeGamesApi(retrofit: Retrofit)=retrofit.create(GamesApi::class.java)

    @Provides
    @Singleton
    fun ProvideFreeGameRepositery(gamesApi: GamesApi):FreeGamesRepositery{
        return FreeGamesRepositeryImplementation(gamesApi)
    }
}