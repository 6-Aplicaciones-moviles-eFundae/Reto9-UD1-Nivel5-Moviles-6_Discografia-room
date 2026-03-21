package com.efundae.moviles.nivel5.ud1.reto9.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BotonFlotante(
    onMostrarDialogo: (Boolean) -> Unit = {}
){
    FloatingActionButton(
        modifier = Modifier.size(80.dp),
        onClick = { onMostrarDialogo(true) },
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Icon(
            modifier = Modifier.size(40.dp),
            imageVector = Icons.Filled.Add,
            contentDescription = "Añadir"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BotonFlotantePreview(){
    BotonFlotante()
}