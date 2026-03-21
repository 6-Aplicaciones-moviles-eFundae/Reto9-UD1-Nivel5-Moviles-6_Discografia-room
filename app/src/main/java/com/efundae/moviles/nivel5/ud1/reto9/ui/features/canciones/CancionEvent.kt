package com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones

sealed interface CancionEvent {
    data object OnGetCanciones : CancionEvent
    data class OnGetCancionById(val id: Int) : CancionEvent
    data object OnGetCancionesCount : CancionEvent
    data class OnInsertCancion(val cancionUiState: CancionUiState) : CancionEvent
    data class OnUpdateCancion(val cancionUiState: CancionUiState) : CancionEvent
    data class OnDeleteCancion(val cancionUiState: CancionUiState) : CancionEvent
}