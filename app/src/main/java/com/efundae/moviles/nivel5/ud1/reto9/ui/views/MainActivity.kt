package com.efundae.moviles.nivel5.ud1.reto9.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.efundae.moviles.nivel4.ud3.reto7.ui.features.settings.SettingsViewModel
import com.efundae.moviles.nivel5.ud1.reto9.ui.navigation.NavHostPrincipal
import com.pmdm.proyectobase2425.ui.theme.ProyectoBaseTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val settingsViewModel: SettingsViewModel by viewModels()
            val isDarkTheme by settingsViewModel.isDarkTheme.collectAsState()
            ProyectoBaseTheme {
                NavHostPrincipal(
                    navController = navController,
                    isDarkTheme = isDarkTheme,
                    onThemeChange = { settingsViewModel.setTheme(it) }
                )
            }
        }
    }
}