package com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AlbumesScreen(
    listaAlbumes: List<AlbumUiState>,
    onAlbumEvent: (AlbumEvent) -> Unit
) {
    LazyColumn {
        items(listaAlbumes) {
            Text(
                text = "${it.id} - ${it.nombre} - ${it.artista}",
                modifier = Modifier.combinedClickable(
                    onClick = {},
                    onLongClick = {
                        onAlbumEvent(AlbumEvent.OnGetAlbumById(it.id))
                    }
                )
            )
        }
    }
}
