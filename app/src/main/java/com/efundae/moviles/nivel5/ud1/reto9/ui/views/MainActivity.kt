package com.efundae.moviles.nivel5.ud1.reto9.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.efundae.moviles.nivel5.ud1.reto9.ui.features.settings.SettingsViewModel
import com.efundae.moviles.nivel5.ud1.reto9.ui.navigation.NavHostPrincipal
import com.efundae.moviles.nivel5.ud1.reto9.ui.theme.DiscografiaTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val settingsViewModel = hiltViewModel<SettingsViewModel>()
            val isDarkTheme by settingsViewModel.isDarkTheme.collectAsState()
            DiscografiaTheme {
                NavHostPrincipal(
                    isDarkTheme = isDarkTheme,
                    onThemeChange = { settingsViewModel.setTheme(it) }
                )
            }
        }
    }
}