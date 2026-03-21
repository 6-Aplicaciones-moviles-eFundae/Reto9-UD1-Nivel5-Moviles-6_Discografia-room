package com.efundae.moviles.nivel5.ud1.reto9.di

import android.content.Context
import android.content.SharedPreferences
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.album.AlbumDao
import com.efundae.moviles.nivel5.ud1.reto9.models.repositories.SettingsRepository
import com.efundae.moviles.nivel5.ud1.reto9.models.repositories.AlbumRepository
import com.efundae.moviles.nivel5.ud1.reto9.data.room.DiscografiaBD
import com.efundae.moviles.nivel5.ud1.reto9.data.room.discografia.cancion.CancionDao
import com.efundae.moviles.nivel5.ud1.reto9.models.repositories.CancionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): DiscografiaBD = DiscografiaBD.getDatabase(context)

    @Provides
    @Singleton
    fun provideAlbumDao(
        albumBD: DiscografiaBD
    ): AlbumDao = albumBD.albumDao()

    @Provides
    @Singleton
    fun provideCancionDao(
        cancionBD: DiscografiaBD
    ): CancionDao = cancionBD.cancionDao()

    @Provides
    @Singleton
    fun provideAlbumRepositorio(
        albumDao: AlbumDao
    ): AlbumRepository = AlbumRepository(albumDao)

    @Provides
    @Singleton
    fun provideCancionRepositorio(
        cancionDao: CancionDao
    ): CancionRepository = CancionRepository(cancionDao)

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences = context.getSharedPreferences("App", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideSettingsRepository(
        sharedPreferences: SharedPreferences
    ): SettingsRepository = SettingsRepository(sharedPreferences)
}