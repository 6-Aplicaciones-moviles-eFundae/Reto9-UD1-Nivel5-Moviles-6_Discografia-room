package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.efundae.moviles.nivel5.ud1.reto9.ui.composables.BarraInferior
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
    val iOpcionNevagacionSeleccionada by remember {
        derivedStateOf {
            iOpcionSeleccionada(
                destino = entradaEnPilaDeNavegacionActuasState?.destination
            )
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Barra superior pendiente de hacer") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                scrollBehavior = comportamientoAnteScroll
            )
        },
        bottomBar = {
            BarraInferior(
                iOpcionSeleccionada = iOpcionNevagacionSeleccionada,
                onNavegarAPantalla = { indice -> navegarAOpcion(navController, indice) }
            )
        }
    ) { paddingValues ->
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
