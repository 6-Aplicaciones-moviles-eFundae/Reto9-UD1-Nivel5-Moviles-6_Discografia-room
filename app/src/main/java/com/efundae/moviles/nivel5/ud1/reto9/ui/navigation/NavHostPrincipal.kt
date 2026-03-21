package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes.AlbumesViewModel
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones.CancionViewModel

@Composable
fun NavHostPrincipal(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    val albumVM = hiltViewModel<AlbumesViewModel>()
    val cancionVM = hiltViewModel<CancionViewModel>()
    NavHost(
        navController = navController,
        startDestination = AlbumesRoute
    ) {
        albumesDestination(
            albumVM = albumVM,
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange,
        )
        cancionesDestination(
            cancionVM = cancionVM,
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange,
        )
    }
}