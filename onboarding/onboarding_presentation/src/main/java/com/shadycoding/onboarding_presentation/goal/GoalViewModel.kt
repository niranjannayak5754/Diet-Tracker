package com.shadycoding.onboarding_presentation.goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shadycoding.core.domain.model.GoalType
import com.shadycoding.core.domain.preferences.Preferences
import com.shadycoding.core.navigation.Route
import com.shadycoding.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalViewModel @Inject constructor(private val preferences: Preferences) : ViewModel() {
    var goalTypeSelected by mutableStateOf<GoalType>(GoalType.KeepWeight)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGoalTypeSelected(goalType: GoalType) {
        goalTypeSelected = goalType
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGoalType(goalTypeSelected)
            _uiEvent.send(UiEvent.Navigate(Route.NUTRIENT_GOAL))
        }
    }
}