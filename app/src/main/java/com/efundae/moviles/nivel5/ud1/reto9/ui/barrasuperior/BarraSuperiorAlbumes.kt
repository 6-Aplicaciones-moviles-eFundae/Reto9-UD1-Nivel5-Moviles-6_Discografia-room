package com.efundae.moviles.nivel5.ud1.reto9.ui.barrasuperior

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperiorAlbumes(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    comportamientoAnteScroll: TopAppBarScrollBehavior,
    hayAlbumSeleccionado: Boolean
) {
    TopAppBar(
        title = { Text("Álbumes") },
        scrollBehavior = comportamientoAnteScroll,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        actions = {
            if (hayAlbumSeleccionado) {
                IconButton(
                    onClick = {},
                    content = {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "Editar",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                )
                IconButton(
                    onClick = {},
                    content = {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Eliminar",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                )
            }
            else {
                IconButton(
                    onClick = { onThemeChange(!isDarkTheme) },
                    content = {
                        Icon(
                            imageVector = if (isDarkTheme) Icons.Filled.DarkMode else Icons.Filled.LightMode,
                            contentDescription = "Cambiar tema",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                )
            }

        }
    )
}