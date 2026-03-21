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

    init {
        getCanciones()
    }

    private fun getCanciones() {
        viewModelScope.launch {
            _listaCanciones.value = repository.get().map { it.toCancion().toCancionUiState() }
        }
    }
}