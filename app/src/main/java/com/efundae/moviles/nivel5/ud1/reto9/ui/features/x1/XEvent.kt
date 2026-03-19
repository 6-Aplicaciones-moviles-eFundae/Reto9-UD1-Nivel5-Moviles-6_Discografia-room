package com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1

sealed interface XEvent {
    data class onGetX(val id: Int) : XEvent
    data class onInsertX(val xUiState: com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1.XUiState) : XEvent
    data class onUpdate(val xUiState: com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1.XUiState) : XEvent
    data class onDeleteX(val xUiState: com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1.XUiState) : XEvent
}