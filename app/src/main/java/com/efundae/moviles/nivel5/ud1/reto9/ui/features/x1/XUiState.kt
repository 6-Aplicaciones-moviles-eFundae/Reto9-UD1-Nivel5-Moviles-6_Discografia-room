package com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1

import com.efundae.moviles.nivel5.ud1.reto9.data.Album


data class XUiState(
    val id: Int = 0
)

fun com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1.XUiState.toX() = Album(
    id = this.id
)

fun Album.toXUiState() =
    _root_ide_package_.com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1.XUiState(
        id = this.id
    )