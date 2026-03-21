package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes.AlbumesViewModel
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes.AlbumesScreen
import kotlinx.serialization.Serializable

@Serializable
data object AlbumesRoute

fun NavGraphBuilder.albumesDestination(
    isDarkTheme: Boolean,
    albumVM: AlbumesViewModel,
    onThemeChange: (Boolean) -> Unit
) {
    composable<AlbumesRoute> {
        AlbumesScreen(
            listaAlbumes = albumVM.listaAlbumes.value,
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange
        )
    }
}