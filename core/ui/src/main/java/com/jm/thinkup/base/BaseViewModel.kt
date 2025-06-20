package com.jm.thinkup.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope

/**************************************************************************************************
 * title : BaseViewModel.kt
 *
 * description : MVI 패턴에서 UiState, UiIntent, SideEffect 를 쉽게 사용하기 위한 기본 ViewModel
 *
 *
 * @author    jongmin0203@pineone.com
 * @since     2025-06-10
 **************************************************************************************************/

abstract class BaseViewModel<UI_STATE : UiState, UI_INTENT : UiIntent, SIDE_EFFECT : SideEffect>(
    initialState: UI_STATE
) : ViewModel(), ContainerHost<UI_STATE, SIDE_EFFECT> {

    override val container: Container<UI_STATE, SIDE_EFFECT> =
        Container(initialState, viewModelScope)

    abstract fun onIntent(intent: UI_INTENT)

    protected fun updateState(reducer: UI_STATE.() -> UI_STATE) {
        container.reduce(reducer)
    }

    protected fun emitSideEffect(sideEffect: SIDE_EFFECT) {
        container.postSideEffect(sideEffect)
    }

    @Composable
    fun collectSideEffect(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        consumeSideEffect: (sideEffect: SIDE_EFFECT) -> Unit
    ) {
        val sideEffectFlow = container.sideEffect
        val lifecycleOwner = LocalLifecycleOwner.current
        val sideEffectConsumer by rememberUpdatedState(consumeSideEffect)

        LaunchedEffect(sideEffectFlow, lifecycleOwner) {
            lifecycleOwner.lifecycle.repeatOnLifecycle(lifecycleState) {
                sideEffectFlow.collect {
                    sideEffectConsumer(it)
                }
            }
        }
    }

    @Composable
    fun rememberUiIntentHandler(): (UI_INTENT) -> Unit = { intent -> onIntent(intent) }
}