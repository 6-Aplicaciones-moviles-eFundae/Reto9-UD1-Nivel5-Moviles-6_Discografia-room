package com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.efundae.moviles.nivel5.ud1.reto9.models.repositories.AlbumRepository
import com.efundae.moviles.nivel5.ud1.reto9.models.toAlbum
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumesViewModel @Inject constructor(
    private val repository: AlbumRepository
) : ViewModel() {
    private val _listaAlbumes = MutableStateFlow<List<AlbumUiState>>(value = emptyList())
    val listaAlbumes = _listaAlbumes.asStateFlow()

    init {
        getAllAlbumes()
    }

    private fun getAllAlbumes(){
        viewModelScope.launch {
            _listaAlbumes.value = repository.get().map { it.toAlbum().toAlbumUiState() }
        }
    }
}