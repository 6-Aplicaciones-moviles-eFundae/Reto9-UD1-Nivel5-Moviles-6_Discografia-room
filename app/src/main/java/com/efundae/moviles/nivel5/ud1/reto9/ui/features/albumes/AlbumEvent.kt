package com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes

sealed interface AlbumEvent {
    data object OnGetAlbumes : AlbumEvent
    data class OnGetAlbumById(val id: Int?) : AlbumEvent
    data object OnGetAlbumesCount : AlbumEvent
    data class OnInsertAlbum(val albumUiState:AlbumUiState) : AlbumEvent
    data class OnUpdateAlbum(val albumUiState:AlbumUiState) : AlbumEvent
    data class OnDeleteAlbum(val albumUiState:AlbumUiState) : AlbumEvent
}