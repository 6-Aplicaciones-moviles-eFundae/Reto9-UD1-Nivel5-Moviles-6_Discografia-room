package com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.cancion

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.album.AlbumEntity

@Entity(
    tableName = "canciones",
    foreignKeys = [
        ForeignKey(
            entity = AlbumEntity::class,
            parentColumns = ["id"],
            childColumns = ["album_id"],
            onDelete = ForeignKey.Companion.CASCADE
        )
    ],
    indices = [Index(value = ["album_id"])]
)
data class CancionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "album_id")
    val albumId : Int,
    val nombre : String,
    val duracion : Int,
    val url : String
)