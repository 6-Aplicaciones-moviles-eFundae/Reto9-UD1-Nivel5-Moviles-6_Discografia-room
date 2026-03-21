package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones.CancionViewModel
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones.CancionesScreen
import kotlinx.serialization.Serializable

@Serializable
data object CancionesRoute

fun NavGraphBuilder.cancionesDestination(
    cancionVM: CancionViewModel,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    composable<CancionesRoute> {
        CancionesScreen(
            pantalla = 1,
            listaCanciones = cancionVM.listaCanciones.value,
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange
        )
    }
}
