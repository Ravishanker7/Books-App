package com.example.gamesapi.presentation.Navigation

sealed class Screens(val route : String) {
    object GameScreen : Screens("game_Screen")
}