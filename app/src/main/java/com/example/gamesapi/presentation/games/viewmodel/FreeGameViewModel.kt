package com.example.gamesapi.presentation.games.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesapi.Domain.model.FreeGames
import com.example.gamesapi.Domain.usecase.FreeGameUseCase
import com.example.gamesapi.core.common.Resource
import com.example.gamesapi.presentation.games.state.FreeGameState
import com.example.gamesapi.presentation.games.state.UIEffect
import com.example.gamesapi.presentation.games.state.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FreeGameViewModel @Inject constructor(private val useCase: FreeGameUseCase) : ViewModel() {

    private val _freeGamesState= MutableStateFlow(FreeGameState())
     val FreeGameState : StateFlow<FreeGameState>
         get() = _freeGamesState

    private val _uiEffect= MutableSharedFlow<UIEffect>()

    val uiEffect : SharedFlow<UIEffect>
        get() = _uiEffect.asSharedFlow()


    init {
        getAllFreeGames()
    }
    private fun getAllFreeGames()=useCase().onEach {
        when(it){
            is Resource.Error->{
                _freeGamesState.value=FreeGameState().copy(Error=it?.msg)
                _uiEffect.emit(UIEffect.ShowSnackbar(it.msg.toString()))
            }
            is Resource.Loadings->{
                _freeGamesState.value=FreeGameState().copy(isLoading = false)
            }
            is Resource.Success->{
                _freeGamesState.value=FreeGameState().copy(freeGames = it.data)
            }
        }
    }.launchIn(viewModelScope)

    fun onEvent(uiEvent: UIEvent){
        when(uiEvent){
            UIEvent.NavigatetoDetailScreen->{

            }
        }
    }
}