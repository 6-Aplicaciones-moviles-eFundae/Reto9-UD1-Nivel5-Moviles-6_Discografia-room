package com.efundae.moviles.nivel5.ud1.reto9.ui.composables.dialogos

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes.AlbumEvent
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes.AlbumUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DialogoEliminarAlbum(
    onMostrarDialogoEliminarAlbum: (Boolean) -> Unit,
    onAlbumEvent: (AlbumEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope,
    albumSeleccionado: AlbumUiState
) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = "Eliminar álbum") },
        text = { Text(text = "¿Seguro que quieres eliminar el álbum ${albumSeleccionado.nombre} de ${albumSeleccionado.artista}?") },
        confirmButton = {
            TextButton(
                onClick = {
                    onAlbumEvent(AlbumEvent.OnDeleteAlbum(albumSeleccionado))
                    onMostrarDialogoEliminarAlbum(false)
                    scope.launch {
                        snackbarHostState.currentSnackbarData?.dismiss()
                        snackbarHostState.showSnackbar(
                            message = "Álbum eliminado correctamente",
                            actionLabel = "Aceptar",
                            duration = SnackbarDuration.Long
                        )
                    }
                }
            ) {
                Text(text = "Eliminar")
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onMostrarDialogoEliminarAlbum(false) }
            ) {
                Text(text = "Cancelar")
            }
        }
    )
}