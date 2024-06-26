package com.example.gamesapi.presentation.Navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gamesapi.presentation.games.components.GameScreen
import com.example.gamesapi.presentation.games.state.UIEffect
import com.example.gamesapi.presentation.games.viewmodel.FreeGameViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.GameScreen.route){
        composable(Screens.GameScreen.route){
            val freeGameViewModel = hiltViewModel<FreeGameViewModel>()
            val state=  freeGameViewModel.FreeGameState.collectAsStateWithLifecycle()
            val snackBarHostState = remember {
                SnackbarHostState()
            }


            GameScreen(freeGameState = state.value, modifier = Modifier)


            LaunchedEffect(key1 = true) {
                freeGameViewModel.uiEffect.collectLatest {
                    when(it){
                        UIEffect.NavigatetoDetailScreen-> TODO()
                        is UIEffect.ShowSnackbar->{
                            snackBarHostState.showSnackbar(it.message)
                        }
                    }
                }
            }
        }
    }
}