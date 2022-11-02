package com.shadycoding.onboarding_presentation.nutrient_goal

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.shadycoding.core.R
import com.shadycoding.core.util.UiEvent
import com.shadycoding.core_ui.LocalSpacing
import com.shadycoding.onboarding_presentation.components.ActionButton
import com.shadycoding.onboarding_presentation.components.UnitTextField

@Composable
fun NutrientGoalScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: NutrientGoalViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.what_are_your_nutrient_goals), style =
                MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = "40",
                onValueChange = {},
                unit = stringResource(id = R.string.percent_carbs)
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = "30",
                onValueChange = {},
                unit = stringResource(id = R.string.percent_proteins)
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = "30",
                onValueChange = {},
                unit = stringResource(id = R.string.percent_fats)
            )
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = {  },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}