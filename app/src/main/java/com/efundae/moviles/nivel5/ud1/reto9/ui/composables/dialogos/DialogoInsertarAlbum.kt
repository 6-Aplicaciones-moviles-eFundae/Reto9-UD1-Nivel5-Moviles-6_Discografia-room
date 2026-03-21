package com.efundae.moviles.nivel5.ud1.reto9.ui.composables.dialogos

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun DialogoInsertarAlbum(onMostrarDialogoInsertarAlbum: (Boolean) -> Unit) {
    AlertDialog(
        onDismissRequest = { onMostrarDialogoInsertarAlbum(false) },
        title = { Text(text = "Añadir álbum") },
        text = { Text(text = "Aquí se añadirá un álbum") },
        confirmButton = {
            TextButton(
                onClick = { onMostrarDialogoInsertarAlbum(false) }
            ) {
                Text(text = "Añadir")
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onMostrarDialogoInsertarAlbum(false) }
            ) {
                Text(text = "Cancelar")
            }
        }
    )
}