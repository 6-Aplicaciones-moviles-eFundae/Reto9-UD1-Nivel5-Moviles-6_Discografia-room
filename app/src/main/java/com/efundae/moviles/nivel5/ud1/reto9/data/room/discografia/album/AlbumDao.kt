package com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.album

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface AlbumDao {
    @Query(value = "SELECT * FROM albumes")
    suspend fun getAll(): List<AlbumEntity>
    @Query(value = "SELECT * FROM albumes WHERE id = :id")
    suspend fun getById(id: Int): AlbumEntity
    @Query(value = "SELECT COUNT(*) FROM albumes")
    suspend fun count(): Int
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(album: AlbumEntity)
    @Update
    suspend fun update(album: AlbumEntity)
    @Delete
    suspend fun delete(album: AlbumEntity)
}