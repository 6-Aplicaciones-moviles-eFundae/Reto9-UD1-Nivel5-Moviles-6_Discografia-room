package com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CancionesScreen(
    pantalla: Int,
    listaCanciones: List<CancionUiState>,
    onThemeChange: (Boolean) -> Unit,
    isDarkTheme: Boolean
) {
    Column() {
        Text("Canciones")
    }
}