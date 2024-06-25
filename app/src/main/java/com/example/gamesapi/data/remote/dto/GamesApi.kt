package com.example.gamesapi.data.remote.dto

import retrofit2.http.GET

interface GamesApi {

    @GET("games")
    suspend fun getFreegames(): List<GamesDTOItem>
}