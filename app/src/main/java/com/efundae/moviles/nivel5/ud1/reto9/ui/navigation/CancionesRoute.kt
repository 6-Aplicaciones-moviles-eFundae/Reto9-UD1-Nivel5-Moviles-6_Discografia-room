package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones.CancionViewModel
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones.CancionesScreen
import kotlinx.serialization.Serializable

@Serializable
data class CancioneRoute(val id: Int)

fun NavGraphBuilder.cancionesDestination(
    cancionVM: CancionViewModel,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    composable<CancioneRoute> { backStackEntry ->
        val id = backStackEntry.arguments?.getInt("id")
        CancionesScreen(
            listaCanciones = cancionVM.listaCanciones.value,
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange
        )
    }
}
