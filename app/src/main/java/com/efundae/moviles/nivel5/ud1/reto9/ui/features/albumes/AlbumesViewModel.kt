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
import kotlin.collections.emptyList

@HiltViewModel
class AlbumesViewModel @Inject constructor(
    private val repository: AlbumRepository
) : ViewModel() {
    private val _listaAlbumes = MutableStateFlow<List<AlbumUiState>>(value = emptyList())
    val listaAlbumes = _listaAlbumes.asStateFlow()
    private val _albumSeleccionado = MutableStateFlow<AlbumUiState?>(value = null)
    val albumSeleccionado = _albumSeleccionado.asStateFlow()

    init {
        getAllAlbumes()
    }

    fun onAlbumEvent(albumEvent: AlbumEvent) {
        when (albumEvent) {
            is AlbumEvent.OnGetAlbumes -> getAllAlbumes()
            is AlbumEvent.OnGetAlbumById -> getAlbum(albumId = albumEvent.id)
            is AlbumEvent.OnGetAlbumesCount -> getAlbumesCount()
            is AlbumEvent.OnInsertAlbum -> insertAlbum(albumEvent.albumUiState)
            is AlbumEvent.OnDeleteAlbum -> deleteAlbum(albumEvent.albumUiState)
            is AlbumEvent.OnUpdateAlbum -> updateAlbum(albumEvent.albumUiState)
        }
    }

    private fun getAllAlbumes() {
        viewModelScope.launch {
            _listaAlbumes.value = repository.get().map { it.toAlbum().toAlbumUiState() }
        }
    }

    private fun getAlbum(albumId: Int?) {
        viewModelScope.launch {
            if (albumId == null) {
                _albumSeleccionado.value = null
            } else {
                _albumSeleccionado.value = repository.get(albumId).toAlbum().toAlbumUiState()
            }
        }
    }

    private fun insertAlbum(album: AlbumUiState) {
        viewModelScope.launch {
            repository.insert(album.toAlbum())
            getAllAlbumes()
        }
    }

    private fun updateAlbum(album: AlbumUiState) {
        viewModelScope.launch {
            repository.update(album.toAlbum())
            _albumSeleccionado.value = null
            getAllAlbumes()
        }
    }

    private fun deleteAlbum(album: AlbumUiState) {
        viewModelScope.launch {
            repository.delete(album.toAlbum())
            _albumSeleccionado.value = null
            getAllAlbumes()
        }
    }

    private fun getAlbumesCount() {
        viewModelScope.launch {

        }
    }
}