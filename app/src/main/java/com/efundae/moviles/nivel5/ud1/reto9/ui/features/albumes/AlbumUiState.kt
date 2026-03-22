package com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes

import com.efundae.moviles.nivel5.ud1.reto9.data.Album


data class AlbumUiState(
    val id: Int = 0,
    val nombre: String = "",
    val artista: String = "",
    val year: Short = 0,
    val genero: String = "",
    val portada: String = ""
)

fun AlbumUiState.toAlbum() = Album(
    id = this.id,
    nombre = this.nombre,
    artista = this.artista,
    year = this.year,
    genero = this.genero,
    portada = this.portada
)

fun Album.toAlbumUiState() = AlbumUiState(
    id = this.id,
    nombre = this.nombre,
    artista = this.artista,
    year = this.year,
    genero = this.genero,
    portada = this.portada
)