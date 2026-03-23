package com.efundae.moviles.nivel5.ud1.reto9.ui.composables.dialogos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Title
import androidx.compose.material.icons.filled.TypeSpecimen
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes.AlbumEvent
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes.AlbumUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DialogoEditarAlbum(
    onMostrarDialogoEditarAlbum: (Boolean) -> Unit,
    albumSeleccionado: AlbumUiState,
    onAlbumEvent: (AlbumEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope
) {
    val (valorNombreAlbum, onValorNombreAlbum) = remember { mutableStateOf(value = albumSeleccionado.nombre) }
    val (valorArtistaAlbum, onValorArtistaAlbum) = remember { mutableStateOf(value = albumSeleccionado.artista) }
    val (valorYearAlbum, onValorYearAlbum) = remember { mutableStateOf(value = albumSeleccionado.year.toString()) }
    val (valorGeneroAlbum, onValorGeneroAlbum) = remember { mutableStateOf(value = albumSeleccionado.genero) }
    val (valorPortadaAlbum, onValorPortadaAlbum) = remember { mutableStateOf(value = albumSeleccionado.portada) }
    val regexYear = remember { Regex(pattern = "^[1-2][0-9]{3}$") }
    val regexPortada = remember { Regex(pattern = "^(http|https)://.*\\.(jpg|jpeg|png)[?]?.*") }
    val (hayCambios, onHayCambios) = remember { mutableStateOf(value = false) }

    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(
                text = "Editar álbum",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(
                horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedTextField(
                    value = valorNombreAlbum,
                    onValueChange = { onValorNombreAlbum(it); onHayCambios(true) },
                    label = { Text(text = "Título") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Title,
                            contentDescription = "Nombre",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    })
                OutlinedTextField(
                    value = valorArtistaAlbum,
                    onValueChange = { onValorArtistaAlbum(it); onHayCambios(true) },
                    label = { Text(text = "Artista") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Artista",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    })
                OutlinedTextField(
                    value = valorYearAlbum,
                    onValueChange = { onValorYearAlbum(it); onHayCambios(true) },
                    label = { Text(text = "Año") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    isError = valorYearAlbum != "" && !regexYear.matches(input = valorYearAlbum),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Timer,
                            contentDescription = "Año",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    })
                OutlinedTextField(
                    value = valorGeneroAlbum,
                    onValueChange = { onValorGeneroAlbum(it); onHayCambios(true) },
                    label = { Text(text = "Géneros") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.TypeSpecimen,
                            contentDescription = "Géneros",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    })
                OutlinedTextField(
                    value = valorPortadaAlbum,
                    onValueChange = { onValorPortadaAlbum(it); onHayCambios(true) },
                    label = { Text(text = "Portada") },
                    singleLine = true,
                    isError = valorPortadaAlbum != "" && !regexPortada.matches(input = valorPortadaAlbum),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Album,
                            contentDescription = "Portada",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onAlbumEvent(
                        AlbumEvent.OnUpdateAlbum(
                            albumUiState = AlbumUiState(
                                id = albumSeleccionado.id,
                                nombre = valorNombreAlbum,
                                artista = valorArtistaAlbum,
                                year = valorYearAlbum.toShort(),
                                genero = valorGeneroAlbum,
                                portada = valorPortadaAlbum
                            )
                        )
                    )
                    onMostrarDialogoEditarAlbum(false)
                    scope.launch {
                        snackbarHostState.currentSnackbarData?.dismiss()
                        snackbarHostState.showSnackbar(
                            message = "Álbum editado correctamente",
                            actionLabel = "Aceptar",
                            duration = SnackbarDuration.Long
                        )
                    }
                },
                enabled = valorNombreAlbum.isNotBlank() && valorArtistaAlbum.isNotBlank()
                        && valorYearAlbum.isNotBlank() && valorGeneroAlbum.isNotBlank()
                        && valorPortadaAlbum.isNotBlank() && regexPortada.matches(input = valorPortadaAlbum)
                        && regexYear.matches(input = valorYearAlbum) && hayCambios
            ) {
                Text(text = "Editar")
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onMostrarDialogoEditarAlbum(false) }
            ) {
                Text(text = "Cancelar")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DialogoEditarAlbumPreview() {
    DialogoEditarAlbum(
        onMostrarDialogoEditarAlbum = {},
        albumSeleccionado = AlbumUiState(
            id = 1,
            nombre = "The Eminem Show",
            artista = "Eminem",
            year = 2002,
            genero = "Rap, Rock",
            portada = "https://m.media-amazon.com/images/I/71n0xmxpw7L._AC_AIweblab1006854,T4_FMavif_SF1050,1050_PQ64_.jpg?aicid=detailPage-mediaBlock"
        ),
        onAlbumEvent = {},
        snackbarHostState = SnackbarHostState(),
        scope = rememberCoroutineScope()
    )
}