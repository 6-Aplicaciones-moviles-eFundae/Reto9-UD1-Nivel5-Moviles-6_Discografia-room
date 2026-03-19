package com.efundae.moviles.nivel5.ud1.reto9.models.repositories

import com.efundae.moviles.nivel5.ud1.reto9.data.Cancion
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.cancion.CancionDao
import com.efundae.moviles.nivel5.ud1.reto9.models.toCancionEntity
import javax.inject.Inject

class CancionRepository @Inject constructor(
    private var dao : CancionDao
) {
    suspend fun get() = dao.getAll()
    suspend fun get(id: Int) = dao.getById(id)
    suspend fun getByAlbumId(albumId: Int) = dao.getByAlbumId(albumId)
    suspend fun count() = dao.count()
    suspend fun insert(cancion: Cancion) = dao.insert(cancion.toCancionEntity())
    suspend fun update(cancion: Cancion) = dao.update(cancion.toCancionEntity())
    suspend fun delete(cancion: Cancion) = dao.delete(cancion.toCancionEntity())
}