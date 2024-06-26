package com.example.gamesapi.presentation.games.state

sealed class UIEffect {
    class ShowSnackbar(val message : String ) : UIEffect()
    object NavigatetoDetailScreen : UIEffect()
}