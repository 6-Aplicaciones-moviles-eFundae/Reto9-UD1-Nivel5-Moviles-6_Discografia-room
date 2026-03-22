package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes.AlbumesViewModel
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes.AlbumesScreen
import kotlinx.serialization.Serializable

@Serializable
data object AlbumesRoute

fun NavGraphBuilder.albumesDestination(
    albumVM: AlbumesViewModel
) {
    composable<AlbumesRoute> {
        val listaAlbumes by albumVM.listaAlbumes.collectAsStateWithLifecycle()
        AlbumesScreen(
            listaAlbumes = listaAlbumes,
            onAlbumEvent = albumVM::onAlbumEvent
        )
    }
}