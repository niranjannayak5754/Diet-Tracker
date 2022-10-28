package com.shadycoding.diet_tracker.navigation

import androidx.navigation.NavController
import com.shadycoding.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate){
    this.navigate(event.route)
}