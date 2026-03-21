package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.efundae.moviles.nivel5.ud1.reto9.ui.barrasuperior.BarraSuperiorAlbumes
import com.efundae.moviles.nivel5.ud1.reto9.ui.barrasuperior.BarraSuperiorCanciones
import com.efundae.moviles.nivel5.ud1.reto9.ui.composables.BarraInferior
import com.efundae.moviles.nivel5.ud1.reto9.ui.composables.BotonFlotante
import com.efundae.moviles.nivel5.ud1.reto9.ui.composables.dialogos.DialogoInsertarAlbum
import com.efundae.moviles.nivel5.ud1.reto9.ui.composables.dialogos.DialogoInsertarCancion
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.albumes.AlbumesViewModel
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.canciones.CancionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavHostPrincipal(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    val albumVM = hiltViewModel<AlbumesViewModel>()
    val cancionVM = hiltViewModel<CancionViewModel>()
    val comportamientoAnteScroll = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val navController = rememberNavController()
    val entradaEnPilaDeNavegacionActuasState by navController.currentBackStackEntryAsState()
    val iOpcionNavegacionSeleccionada by remember {
        derivedStateOf {
            when {
                entradaEnPilaDeNavegacionActuasState == null -> 0
                entradaEnPilaDeNavegacionActuasState!!.destination.hasRoute<AlbumesRoute>() -> 0
                entradaEnPilaDeNavegacionActuasState!!.destination.hasRoute<CancionesRoute>() -> 1
                else -> 0
            }
        }
    }
    val (mostrarDialogoInsertarAlbum, onMostrarDialogoInsertarAlbum) = remember {
        mutableStateOf(value = false)
    }
    val (mostrarDialogoInsertarCancion, onMostrarDialogoInsertarCancion) = remember {
        mutableStateOf(value = false)
    }
    Scaffold(
        topBar = {
            when (iOpcionNavegacionSeleccionada) {
                0 -> BarraSuperiorAlbumes(
                    isDarkTheme = isDarkTheme,
                    onThemeChange = onThemeChange,
                    comportamientoAnteScroll = comportamientoAnteScroll,
                    hayAlbumSeleccionado = albumVM.albumSeleccionado == null
                )
                1 -> BarraSuperiorCanciones(
                    isDarkTheme = isDarkTheme,
                    onThemeChange = onThemeChange,
                    comportamientoAnteScroll = comportamientoAnteScroll,
                    hayCancionSeleccionada = cancionVM.cancionSeleccionada == null
                )
            }
        },
        bottomBar = {
            BarraInferior(
                iOpcionSeleccionada = iOpcionNavegacionSeleccionada,
                onNavegarAPantalla = { indice -> navegarAOpcion(navController, indice) }
            )
        },
        floatingActionButton = {
            BotonFlotante(onMostrarDialogo = {
                when (iOpcionNavegacionSeleccionada) {
                    0 -> onMostrarDialogoInsertarAlbum(it)
                    1 -> {
                        onMostrarDialogoInsertarCancion(it)
                    }
                }
            })
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        if (mostrarDialogoInsertarAlbum) {
            DialogoInsertarAlbum(onMostrarDialogoInsertarAlbum)
        }
        if (mostrarDialogoInsertarCancion) {
            DialogoInsertarCancion(onMostrarDialogoInsertarCancion)
        }
        NavHost(
            navController = navController,
            startDestination = AlbumesRoute,
            modifier = Modifier.padding(paddingValues)
        ) {
            albumesDestination(
                isDarkTheme = isDarkTheme,
                albumVM = albumVM,
                onThemeChange = onThemeChange
            )
            cancionesDestination(
                cancionVM = cancionVM,
                isDarkTheme = isDarkTheme,
                onThemeChange = onThemeChange
            )
        }
    }
}
