package com.efundae.moviles.nivel5.ud1.reto9.models

import com.efundae.moviles.nivel5.ud1.reto9.data.Album
import com.efundae.moviles.nivel5.ud1.reto9.data.Cancion
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.album.AlbumEntity
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.cancion.CancionEntity

fun Album.toAlbumEntity() = AlbumEntity(
    id = this.id,
    nombre = this.nombre,
    artista = this.artista,
    year = this.year,
    genero = this.genero,
    portada = this.portada
)

fun AlbumEntity.toAlbum() = Album(
    id = this.id,
    nombre = this.nombre,
    artista = this.artista,
    year = this.year,
    genero = this.genero,
    portada = this.portada
)

fun Cancion.toCancionEntity() = CancionEntity(
    id = this.id,
    albumId = this.albumId,
    nombre = this.nombre,
    duracion = this.duracion,
    url = this.url
)

fun CancionEntity.toCancion() = Cancion(
    id = this.id,
    albumId = this.albumId,
    nombre = this.nombre,
    duracion = this.duracion,
    url = this.url
)