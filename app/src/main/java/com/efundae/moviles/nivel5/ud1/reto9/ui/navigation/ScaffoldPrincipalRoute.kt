package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.efundae.ui.features.x1.XViewModel
import com.efundae.ui.features.x1.ScaffoldPrincipalScreen
import kotlinx.serialization.Serializable

@Serializable
data object ScaffoldPrincipalRoute

fun NavGraphBuilder.scaffoldPrincipalDestination(
    onIrAPantallaB: (Int) -> Unit,
    xVM:  XViewModel,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    composable<ScaffoldPrincipalRoute> {
        ScaffoldPrincipalScreen(
            onIrPantallaB = onIrAPantallaB,
            xVm = xVM,
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange
        )
    }
}