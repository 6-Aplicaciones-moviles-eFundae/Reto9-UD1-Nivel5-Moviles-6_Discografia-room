package com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.cancion

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface CancionDao {
    @Query(value = "SELECT * FROM canciones")
    suspend fun getAll(): List<CancionEntity>
    @Query(value = "SELECT * FROM canciones WHERE id = :id")
    suspend fun getById(id: Int): CancionEntity
    @Query(value = "SELECT * FROM canciones WHERE album_id = :albumId")
    suspend fun getByAlbumId(albumId: Int): List<CancionEntity>
    @Query(value = "SELECT COUNT(*) FROM canciones")
    suspend fun count(): Int
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(cancion: CancionEntity)
    @Update
    suspend fun update(cancion: CancionEntity)
    @Delete
    suspend fun delete(cancion: CancionEntity)
}