package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones.CancionViewModel
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones.CancionesScreen
import kotlinx.serialization.Serializable

@Serializable
data object CancionesRoute

fun NavGraphBuilder.cancionesDestination(
    cancionVM: CancionViewModel
) {
    composable<CancionesRoute> {
        val listaCanciones by cancionVM.listaCanciones.collectAsStateWithLifecycle()
        CancionesScreen(
            listaCanciones = listaCanciones,
        )
    }
}
