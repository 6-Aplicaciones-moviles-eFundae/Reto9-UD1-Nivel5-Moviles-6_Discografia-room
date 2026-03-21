package com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones

import com.efundae.moviles.nivel5.ud1.reto9.data.Cancion

data class CancionUiState(
    val id: Int = 0,
    val nombre: String = "",
    val duracion: Int = 0,
    val albumId: Int = 0,
    val url: String = ""
)

fun CancionUiState.toCancion() = Cancion(
    id = this.id,
    nombre = this.nombre,
    duracion = this.duracion,
    albumId = this.albumId,
    url = this.url
)

fun Cancion.toCancionUiState() = CancionUiState(
    id = this.id,
    nombre = this.nombre,
    duracion = this.duracion,
    albumId = this.albumId,
    url = this.url
)