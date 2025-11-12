package com.example.ryuu_fit.Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ryuu_fit.pantallas.LoginScreen
import com.example.ryuu_fit.pantallas.TestInicialScreen
import com.example.ryuu_fit.pantallas.HomeScreen

// Rutas Johan
import com.example.ryuu_fit.pantallas.detallesEjercicio
import com.example.ryuu_fit.pantallas.detallesTraining
import com.example.ryuu_fit.pantallas.trainingWeek

// Rutas Julian
import com.example.ryuu_fit.pantallas.RutinaScreen
import com.example.ryuu_fit.pantallas.MenuScreen
import com.example.ryuu_fit.pantallas.CardioScreen
import com.example.ryuu_fit.pantallas.FuerzaScreen
import com.example.ryuu_fit.pantallas.ResistenciaScreen
import com.example.ryuu_fit.pantallas.ElasticidadScreen

@Composable
fun NavegacionApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppPantallas.Login.ruta
    ) {
        // Pantallas principales
        composable(route = AppPantallas.Login.ruta) {
            LoginScreen(navController)
        }
        composable(route = AppPantallas.Home.ruta) {
            HomeScreen(navController)
        }
        composable(route = AppPantallas.Test.ruta) {
            TestInicialScreen(navController)
        }

        // Parte de Johan
        composable(route = AppPantallas.DetallesTr.ruta) {
            detallesTraining(navController)
        }
        composable(route = AppPantallas.DetallesEx.ruta) {
            detallesEjercicio(navController)
        }
        composable(route = AppPantallas.TrainingWeek.ruta) {
            trainingWeek(navController)
        }

        // Parte de Julian
        composable(route = AppPantallas.Rutina.ruta) {
            RutinaScreen(
                onSalirClick = {
                    navController.navigateUp()
                }
            )
        }

        composable(route = AppPantallas.Menu.ruta) {
            MenuScreen(navController)
        }

        composable(route = AppPantallas.Cardio.ruta) {
            CardioScreen(navController = navController)
        }


        composable(route = AppPantallas.Fuerza.ruta) {
            FuerzaScreen(
                onFinalizarClick = {
                    navController.navigate(AppPantallas.Home.ruta) {
                        popUpTo(AppPantallas.Rutina.ruta) { inclusive = true }
                    }
                }
            )
        }

        composable(route = AppPantallas.Resistencia.ruta) {
            ResistenciaScreen(
                onFinalizarClick = {
                    navController.navigate(AppPantallas.Home.ruta) {
                        popUpTo(AppPantallas.Rutina.ruta) { inclusive = true }
                    }
                }
            )
        }

        composable(route = AppPantallas.Elasticidad.ruta) {
            ElasticidadScreen(
                onFinalizarClick = {
                    navController.navigate(AppPantallas.Home.ruta) {
                        popUpTo(AppPantallas.Rutina.ruta) { inclusive = true }
                    }
                }
            )
        }
    }


}