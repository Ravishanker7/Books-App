package com.example.gamesapi.data.repositery

import com.example.gamesapi.Domain.model.FreeGames
import com.example.gamesapi.Domain.repositery.FreeGamesRepositery
import com.example.gamesapi.core.common.Resource
import com.example.gamesapi.data.remote.dto.GamesApi
import com.example.gamesapi.data.remote.dto.GamesDTOItem
import com.example.gamesapi.data.remote.mapper.toDomainFreeGames
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class FreeGamesRepositeryImplementation @Inject constructor(private val freeGamesApi : GamesApi): FreeGamesRepositery {

    override fun getFreeGames(): Flow<Resource<List<FreeGames>>> = flow{
        emit(Resource.Loadings())

        try {
            val result = freeGamesApi.getFreegames().map {
                it.toDomainFreeGames()
            }
            emit(Resource.Success(result))
        }catch (e : Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }
}