package com.example.gamesapi.data.remote.mapper

import com.example.gamesapi.Domain.model.FreeGames
import com.example.gamesapi.data.remote.dto.GamesDTOItem

fun  GamesDTOItem.toDomainFreeGames() : FreeGames {
    return FreeGames(gameUrl, id, shortDescription, thumbnail, title)
}