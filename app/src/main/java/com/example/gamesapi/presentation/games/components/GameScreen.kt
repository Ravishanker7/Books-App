package com.example.gamesapi.presentation.games.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.gamesapi.presentation.Navigation.Screens
import com.example.gamesapi.presentation.games.state.FreeGameState

@Composable
fun GameScreen(freeGameState: FreeGameState,modifier: Modifier){

    if(freeGameState?.freeGames?.isNotEmpty()!!){
        LazyColumn {
            items(freeGameState.freeGames){
                FreeGameitem(modifier = modifier, games =it )
            }
        }
    }else if (freeGameState.isLoading){
        Column(modifier=Modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }
    }
}