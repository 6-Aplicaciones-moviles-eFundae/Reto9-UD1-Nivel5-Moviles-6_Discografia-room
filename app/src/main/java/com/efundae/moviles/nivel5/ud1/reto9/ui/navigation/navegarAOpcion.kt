package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.navigation.NavController

fun navegarAOpcion(navController: NavController, indice: Int) {
    val ruta = when (indice) {
        0 -> AlbumesRoute
        1 -> CancionesRoute
        else -> AlbumesRoute
    }
    navController.navigate(ruta) {
        popUpTo(navController.graph.startDestinationId) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
