package com.efundae.moviles.nivel5.ud1.reto9.ui.composables.dialogos

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun DialogoInsertarCancion(onMostrarDialogoInsertarCancion: (Boolean) -> Unit) {
    AlertDialog(
        onDismissRequest = { onMostrarDialogoInsertarCancion(false) },
        title = { Text(text = "Añadir canción") },
        text = { Text(text = "Aquí se añadirá una canción") },
        confirmButton = {
            TextButton(
                onClick = { onMostrarDialogoInsertarCancion(false) }
            ) {
                Text(text = "Añadir")
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onMostrarDialogoInsertarCancion(false) }
            ) {
                Text(text = "Cancelar")
            }
        }
    )
}