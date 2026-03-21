package com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.efundae.moviles.nivel5.ud1.reto9.models.repositories.CancionRepository
import com.efundae.moviles.nivel5.ud1.reto9.models.toCancion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CancionViewModel @Inject constructor(
    private val repository: CancionRepository
) : ViewModel() {
    private val _listaCanciones = MutableStateFlow<List<CancionUiState>>(value = emptyList())
    val listaCanciones = _listaCanciones.asStateFlow()
    private val _cancionSeleccionada = MutableStateFlow<CancionUiState?>(value = null)
    val cancionSeleccionada = _cancionSeleccionada.asStateFlow()

    init {
        getCanciones()
    }

    fun onCancionEvent(cancioEvent: CancionEvent) {
        when (cancioEvent) {
            is CancionEvent.OnGetCanciones -> getCanciones()
            is CancionEvent.OnGetCancionById -> getCancion(cancionId = cancioEvent.id)
            is CancionEvent.OnGetCancionesCount -> getCancionesCount()
            is CancionEvent.OnInsertCancion -> insertCancion(cancioEvent.cancionUiState)
            is CancionEvent.OnDeleteCancion -> deleteCancion(cancioEvent.cancionUiState)
            is CancionEvent.OnUpdateCancion -> updateCancion(cancioEvent.cancionUiState)
        }
    }

    private fun getCanciones() {
        viewModelScope.launch {
            _listaCanciones.value = repository.get().map { it.toCancion().toCancionUiState() }
        }
    }

    private fun getCancion(cancionId: Int) {
        viewModelScope.launch {
            _cancionSeleccionada.value = repository.get(cancionId).toCancion().toCancionUiState()
        }
    }

    private fun getCancionesCount() {
        viewModelScope.launch {

        }
    }

    private fun insertCancion(cancion: CancionUiState) {
        viewModelScope.launch {
            repository.insert(cancion.toCancion())
            getCanciones()
        }
    }

    private fun updateCancion(cancion: CancionUiState) {
        viewModelScope.launch {
            repository.update(cancion.toCancion())
            getCanciones()
        }
    }

    private fun deleteCancion(cancion: CancionUiState) {
        viewModelScope.launch {
            repository.delete(cancion.toCancion())
            getCanciones()
        }
    }
}