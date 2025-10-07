package com.example.ryuu_fit.Navegacion


import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.ryuu_fit.pantallas.LoginScreen
import com.example.ryuu_fit.pantallas.TestInicialScreen
import com.example.ryuu_fit.pantallas.HomeScreen


//Rutas Johan
import com.example.ryuu_fit.pantallas.detallesEjercicio
import com.example.ryuu_fit.pantallas.detallesTraining
import com.example.ryuu_fit.pantallas.trainingWeek

//Rutas Julian
import com.example.ryuu_fit.pantallas.RutinaScreen
import com.example.ryuu_fit.pantallas.MenuScreen


//import com.example.ryuu_fit.pantallas.(nombre de la funcion)


@Composable
fun NavegacionApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppPantallas.Login.ruta
    )
    {
        composable(route = AppPantallas.Login.ruta) {
            LoginScreen(navController)
        }
        composable(route = AppPantallas.Home.ruta) {
            HomeScreen(navController)
        }
        composable(route = AppPantallas.Test.ruta) {
            TestInicialScreen(navController)
        }

        //Partes de Johan
        composable(route = AppPantallas.DetallesTr.ruta) {
            detallesTraining(navController)
        }

        composable(route = AppPantallas.DetallesEx.ruta) {
            detallesEjercicio(navController)
        }

        composable(route = AppPantallas.TrainingWeek.ruta) {
            trainingWeek(navController)
        }


        //Partes Julian
        composable(route = AppPantallas.Rutina.ruta) {
            RutinaScreen(
                onSalirClick = {
                    navController.navigateUp() // vuelve atrás
                }
            )
        }

        composable(route = AppPantallas.Menu.ruta) {
            MenuScreen(navController)
        }


    }

}