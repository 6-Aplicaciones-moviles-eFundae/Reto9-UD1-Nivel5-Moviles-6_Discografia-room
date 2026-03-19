package com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.efundae.moviles.nivel5.ud1.reto9.models.repositories.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@SuppressLint("MutableCollectionMutableState")
@HiltViewModel
class XViewModel @Inject constructor(
    private val repository: AlbumRepository
) : ViewModel() {

    var xState by mutableStateOf(cargarX())
    var tareaSeleccionada: com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1.XUiState? by mutableStateOf(
        _root_ide_package_.com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1.XUiState()
    )
    private fun cargarX() = repository.get().map { it.toXUiState() }.toMutableList()


    fun onXEvent(xEvent: com.efundae.moviles.nivel5.ud1.reto9.ui.features.x1.XEvent) {
        when (xEvent) {
            is XEvent.onGetX -> {
                xSeleccionado = repository.get(xEvent.id)?.toXUiState()
            }

            is XEvent.onInsertX -> {
                repository.insert(xEvent.xUiState.toX())
            }

            is XEvent.onUpdate -> {
                repository.update(xEvent.xUiState.toX())
            }

            is XEvent.onDeleteX -> {
                repository.delete(xEvent.xUiState.toX())
            }
        }
    }
}