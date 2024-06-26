package com.example.gamesapi.data.repositery

import com.example.gamesapi.Domain.model.FreeGames
import com.example.gamesapi.Domain.repositery.FreeGamesRepositery
import com.example.gamesapi.core.common.Resource
import com.example.gamesapi.data.remote.dto.GamesApi
import com.example.gamesapi.data.remote.dto.GamesDTOItem
import com.example.gamesapi.data.remote.mapper.toDomainFreeGames
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject


class FreeGamesRepositeryImplementation @Inject constructor(private val freeGamesApi : GamesApi): FreeGamesRepositery {

    override fun getFreeGames(): Flow<Resource<List<FreeGames>>> = flow{
        emit(Resource.Loadings())


            val result = freeGamesApi.getFreegames().map {
                it.toDomainFreeGames()
            }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }
}