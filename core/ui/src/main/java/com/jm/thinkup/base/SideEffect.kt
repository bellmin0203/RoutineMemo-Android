package com.jm.thinkup.base

interface SideEffect {
    data class ShowToast(val message: String) : SideEffect
}