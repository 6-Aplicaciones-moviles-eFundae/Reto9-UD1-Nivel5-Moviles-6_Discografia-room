package com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.album

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albumes")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre : String,
    val year : Short,
    val genero : String,
    val portada : String
)