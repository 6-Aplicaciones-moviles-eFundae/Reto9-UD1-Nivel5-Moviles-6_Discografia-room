package com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun AlbumesScreen(
    listaAlbumes: List<AlbumUiState>,
    onAlbumEvent: (AlbumEvent) -> Unit,
    albumSeleccionado: AlbumUiState?
) {
    val configuration = LocalConfiguration.current
    val lazyGridState = rememberLazyGridState()
    val columnas = if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        5
    } else {
        2
    }
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(count = columnas),
        state = lazyGridState
    ) {
        items(listaAlbumes) { album ->
            val isSelected = albumSeleccionado?.id == album.id
            Card(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .combinedClickable(
                        onClick = {},
                        onLongClick = {
                            onAlbumEvent(AlbumEvent.OnGetAlbumById(album.id))
                        }
                    ),
                border = BorderStroke(
                    width = if (isSelected) 2.dp else 1.dp,
                    color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = if (isSelected) 15.dp else 10.dp
                )
            ) {
                Box {
                    Column(modifier = Modifier.padding(5.dp)) {
                        GlideImage(
                            model = album.portada,
                            contentDescription = "Portada del álbum ${album.nombre}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .padding(bottom = 5.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = album.nombre,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.titleMedium,
                            minLines = 1,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(
                                start = 2.dp,
                                end = 2.dp,
                                bottom = 1.dp,
                                top = 2.dp
                            )
                        )
                        Text(
                            text = album.artista,
                            minLines = 1,
                            maxLines = 1,
                            style = MaterialTheme.typography.labelLarge,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(start = 2.dp, end = 2.dp, bottom = 2.dp),
                            fontWeight = FontWeight.Light
                        )
                    }
                    if (isSelected) {
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumesScreenPreview() {
    AlbumesScreen(
        listaAlbumes = listOf(
            AlbumUiState(
                id = 1,
                nombre = "The Eminem Show",
                artista = "Eminem",
                year = 2002,
                genero = "Rap, Rock",
                portada = "https://m.media-amazon.com/images/I/71n0xmxpw7L._AC_AIweblab1006854,T4_FMavif_SF1050,1050_PQ64_.jpg?aicid=detailPage-mediaBlock"
            ),
        ),
        onAlbumEvent = {},
        albumSeleccionado = null
    )
}
