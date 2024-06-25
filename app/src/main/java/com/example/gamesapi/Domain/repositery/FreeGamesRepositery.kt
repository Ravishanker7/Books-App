package com.example.gamesapi.Domain.repositery

import com.example.gamesapi.Domain.model.FreeGames
import com.example.gamesapi.core.common.Resource
import com.example.gamesapi.data.remote.dto.GamesDTOItem
import kotlinx.coroutines.flow.Flow

interface FreeGamesRepositery {

    fun getFreeGames() : Flow<Resource<List<FreeGames>>>
}