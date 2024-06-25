package com.example.gamesapi.Domain.usecase

import com.example.gamesapi.Domain.repositery.FreeGamesRepositery
import javax.inject.Inject

class FreeGameUseCase @Inject constructor(private val repositery: FreeGamesRepositery) {
    operator fun invoke()=repositery.getFreeGames()
}