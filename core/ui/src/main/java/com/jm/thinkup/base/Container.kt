package com.jm.thinkup.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**************************************************************************************************
 * title : Container.kt
 *
 * description : MVI 패턴에서 UI State와 Side Effect를 관리하는 클래스
 *
 *
 * @author    jongmin0203@pineone.com
 * @since     2025-06-10
 **************************************************************************************************/

class Container<UI_STATE : UiState, SIDE_EFFECT : SideEffect>(
    initialState: UI_STATE,
    private val scope: CoroutineScope,
) {
    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<UI_STATE> = _uiState.asStateFlow()

    private val _sideEffect = Channel<SIDE_EFFECT>(Channel.BUFFERED)
    val sideEffect = _sideEffect.receiveAsFlow()

    fun reduce(reducer: UI_STATE.() -> UI_STATE) {
        _uiState.update { _uiState.value.reducer() }
    }

    fun postSideEffect(sideEffect: SIDE_EFFECT) {
        scope.launch { _sideEffect.send(sideEffect) }
    }
}