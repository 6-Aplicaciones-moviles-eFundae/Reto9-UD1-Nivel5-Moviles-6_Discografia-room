package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute

fun iOpcionSeleccionada(destino : NavDestination?) : Int{
    return when {
        destino == null -> 0
        destino.hasRoute<AlbumesRoute>() -> 0
        destino.hasRoute<CancionesRoute>() -> 1
        else -> 0
    }
}