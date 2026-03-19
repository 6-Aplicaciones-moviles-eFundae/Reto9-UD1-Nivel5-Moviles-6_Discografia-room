package com.efundae.moviles.nivel5.ud1.reto9.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data class PantallaBRoute(val id: Int)

fun NavGraphBuilder.pantallaBDestination(

) {
    composable<PantallaBRoute> { backStackEntry ->
        val id = backStackEntry.arguments?.getInt("id")

    }
}
