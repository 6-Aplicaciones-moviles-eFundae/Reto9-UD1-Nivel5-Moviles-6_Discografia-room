package com.efundae.moviles.nivel5.ud1.reto9.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.outlined.Album
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import com.efundae.moviles.nivel5.ud1.reto9.data.OpcionBarraInferior

@Composable
fun BarraInferior(
    iOpcionSeleccionada: Int,
    onNavegarAPantalla: (Int) -> Unit
) {
    val opcionesBarraInferior = remember {
        listOf(
            OpcionBarraInferior(
                id = 0,
                titulo = "Álbumes",
                iconoPorDefecto = Icons.Outlined.Album,
                iconoSeleccionado = Icons.Filled.Album
            ),
            OpcionBarraInferior(
                id = 1,
                titulo = "Canciones",
                iconoPorDefecto = Icons.Outlined.MusicNote,
                iconoSeleccionado = Icons.Filled.MusicNote
            )
        )
    }
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        opcionesBarraInferior.forEachIndexed { index, opcion ->
            NavigationBarItem(
                selected = index == iOpcionSeleccionada,
                onClick = { onNavegarAPantalla(index) },
                label = {
                    Text(
                        text = opcion.titulo,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = if (iOpcionSeleccionada == index) FontWeight.ExtraBold else FontWeight.Normal
                    )
                },
                icon = {
                    Icon(
                        imageVector = if (iOpcionSeleccionada == index) opcion.iconoSeleccionado else opcion.iconoPorDefecto,
                        contentDescription = opcion.titulo,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            )
        }
    }
}