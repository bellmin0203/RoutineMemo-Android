package com.jm.thinkup.home

import androidx.lifecycle.viewModelScope
import com.jm.logutil.LogUtil
import com.jm.thinkup.base.BaseViewModel
import com.jm.thinkup.home.model.HomeSideEffect
import com.jm.thinkup.home.model.HomeUiIntent
import com.jm.thinkup.home.model.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeUiState, HomeUiIntent, HomeSideEffect>(HomeUiState.Loading) {
    override fun onIntent(intent: HomeUiIntent) {

        viewModelScope.launch {
            LogUtil.d("received intent: $intent")
            when (intent) {
                HomeUiIntent.AddGoal -> TODO()
            }
        }
    }


}