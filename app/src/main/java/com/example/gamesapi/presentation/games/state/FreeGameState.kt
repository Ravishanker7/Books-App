package com.example.gamesapi.presentation.games.state

import com.example.gamesapi.Domain.model.FreeGames

data class FreeGameState(
    val freeGames : List<FreeGames>? = emptyList(),
    val isLoading : Boolean=false,
    val Error : String? =""
)