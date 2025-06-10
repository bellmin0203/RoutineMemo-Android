package com.jm.thinkup.base

interface ContainerHost<UI_STATE : UiState, SIDE_EFFECT : SideEffect> {
    val container: Container<UI_STATE, SIDE_EFFECT>
}