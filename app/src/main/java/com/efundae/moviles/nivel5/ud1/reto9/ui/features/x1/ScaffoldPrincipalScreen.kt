package com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScaffoldPrincipalScreen(
    onIrPantallaB: (Int) -> Unit,
    xVm: com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1.XViewModel,
    onThemeChange: (Boolean) -> Unit,
    isDarkTheme: Boolean
) {
    Scaffold() { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text("Hola, Ainara")
        }
    }
}