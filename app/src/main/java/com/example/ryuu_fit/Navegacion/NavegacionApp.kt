package com.example.ryuu_fit.Navegacion

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ryuu_fit.ViewModel.TestViewModel
import com.example.ryuu_fit.ViewModel.TestViewModelFactory
import com.example.ryuu_fit.pantallas.*

@Composable
fun NavegacionApp() {
    val navController = rememberNavController()

    // 🔥 Crear el Factory con el contexto de la aplicación
    val context = androidx.compose.ui.platform.LocalContext.current
    val factory = TestViewModelFactory(context.applicationContext as Application)

    // 🔥 Crear una única instancia del ViewModel que se compartirá entre pantallas
    val testViewModel: TestViewModel = viewModel(factory = factory)

    NavHost(
        navController = navController,
        startDestination = AppPantallas.Login.ruta
    ) {
        composable(route = AppPantallas.Login.ruta) {
            LoginScreen(navController)
        }

        composable(route = AppPantallas.Home.ruta) {
            HomeScreen(navController)
        }

        composable(route = AppPantallas.Test.ruta) {
            // 🔥 Pasar el ViewModel compartido
            TestInicialScreen(navController, testViewModel)
        }

        // Partes de Johan
        composable(route = AppPantallas.DetallesTr.ruta) {
            detallesTraining(navController)
        }

        composable(route = AppPantallas.DetallesEx.ruta) {
            detallesEjercicio(navController)
        }

        composable(route = AppPantallas.TrainingWeek.ruta) {
            // 🔥 Pasar el ViewModel compartido
            trainingWeek(navController, testViewModel)
        }

        composable(route = AppPantallas.Lunes.ruta) {
            lunes(navController)
        }

        composable(route = AppPantallas.Martes.ruta) {
            martes(navController)
        }

        composable(route = AppPantallas.Miercoles.ruta) {
            miercoles(navController)
        }

        composable(route = AppPantallas.Viernes.ruta) {
            viernes(navController)
        }

        composable(route = AppPantallas.Sabado.ruta) {
            sabado(navController)
        }

        composable(route = AppPantallas.LEstiramientoBr.ruta) {
            EstiramientoBrazos(navController)
        }

        composable(route = AppPantallas.LFlexApoyandoRod.ruta) {
            FlexionApoyandoRodillas(navController)
        }

        composable(route = AppPantallas.LFlexContraPar.ruta) {
            FlexionContraPared(navController)
        }

        composable(route = AppPantallas.LFondoSilas.ruta) {
            FondoSilla(navController)
        }

        composable(route = AppPantallas.MCurlBotellas.ruta) {
            CurlBotellas(navController)
        }

        composable(route = AppPantallas.MEstiramientoBrazos.ruta) {
            EstiramientoBrazosCr(navController)
        }

        composable(route = AppPantallas.MRemoToalla.ruta) {
            RemoToalla(navController)
        }

        composable(route = AppPantallas.MSuperman.ruta) {
            SupermanTumbado(navController)
        }

        composable(route = AppPantallas.JElevacionLat.ruta) {
            ElevacionesLaterales(navController)
        }

        composable(route = AppPantallas.MiElevacionTal.ruta) {
            ElevacionTalones(navController)
        }

        composable(route = AppPantallas.MiMarchaSitio.ruta) {
            MarchaSitio(navController)
        }

        composable(route = AppPantallas.MiPuenteGluteo.ruta) {
            PuenteGluteo(navController)
        }

        composable(route = AppPantallas.MISentadillasPar.ruta) {
            SentadillasParciales(navController)
        }

        composable(route = AppPantallas.JFlexPica.ruta) {
            FlexPica(navController)
        }

        composable(route = AppPantallas.JPlanchaFrontal.ruta) {
            PlanchaFrontal(navController)
        }

        composable(route = AppPantallas.VFlexPared.ruta) {
            FlexPared(navController)
        }

        composable(route = AppPantallas.VMarchaActiva.ruta) {
            MarchaActiva(navController)
        }

        composable(route = AppPantallas.VRespiracion.ruta) {
            Respiracion(navController)
        }

        composable(route = AppPantallas.VSentadillaExten.ruta) {
            SentadillaExten(navController)
        }

        composable(route = AppPantallas.SAbdomCortos.ruta) {
            AbdomCortos(navController)
        }

        composable(route = AppPantallas.SElevacionLatPier.ruta) {
            ElevacionLat(navController)
        }

        composable(route = AppPantallas.SPlanchaAnteb.ruta) {
            PlanchaAntebrazos(navController)
        }

        composable(route = AppPantallas.SSentadiApoyo.ruta) {
            SentadillasApoyo(navController)
        }

        // Partes Julian
        composable(route = AppPantallas.Nutricion.ruta) {
            Nutricion(
                onSalirClick = { navController.navigateUp() },
                onNavigateTo = { ruta -> navController.navigate(ruta) }
            )
        }

        // Jhon quenan
        composable(route = AppPantallas.Menu.ruta) {
            MenuScreen(
                onSalirClick = { navController.navigateUp() },
                onNavigateTo = { ruta -> navController.navigate(ruta) }
            )
        }

        composable(route = "dieta_desayuno") {
            DietaDesayuno(onBack = { navController.popBackStack() })
        }

        composable(route = "dieta_merienda") {
            DietaMerienda(onBack = { navController.popBackStack() })
        }

        composable(route = "dieta_almuerzo") {
            DietaAlmuerzo(onBack = { navController.popBackStack() })
        }

        composable(route = "dieta_cena") {
            DietaCena(onBack = { navController.popBackStack() })
        }

        composable(route = "dieta_snack") {
            DietaSnack(onBack = { navController.popBackStack() })
        }
    }
}