package com.efundae.moviles.nivel5.ud1.reto9.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.album.AlbumDao
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.album.AlbumEntity
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.cancion.CancionDao
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.cancion.CancionEntity

@Database(
    entities = [AlbumEntity::class, CancionEntity::class],
    version = 1,
    exportSchema = true
)
abstract class DiscografiaBD : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
    abstract fun cancionDao() : CancionDao

    companion object {
        const val DATABASE_NAME = "discografia"
        fun getDatabase(context: Context): DiscografiaBD {
            return Room.databaseBuilder(
                context = context,
                klass = DiscografiaBD::class.java,
                name = DATABASE_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}