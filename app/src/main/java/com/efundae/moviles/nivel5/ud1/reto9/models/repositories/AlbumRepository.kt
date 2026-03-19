package com.efundae.moviles.nivel5.ud1.reto9.models.repositories

import com.efundae.moviles.nivel5.ud1.reto9.data.Album
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.album.AlbumDao
import com.efundae.moviles.nivel5.ud1.reto9.models.toAlbumEntity
import javax.inject.Inject

class AlbumRepository @Inject constructor(
    private var dao: AlbumDao
) {
    suspend fun get() = dao.getAll()
    suspend fun get(id: Int) = dao.getById(id)
    suspend fun insert(album: Album) = dao.insert(album = album.toAlbumEntity())
    suspend fun update(album: Album) = dao.update(album = album.toAlbumEntity())

    suspend fun delete(album: Album) = dao.delete(album = album.toAlbumEntity())
    suspend fun count() = dao.count()
}