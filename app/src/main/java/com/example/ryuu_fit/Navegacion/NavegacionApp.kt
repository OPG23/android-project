package com.example.ryuu_fit.Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ryuu_fit.pantallas.AbdomCortos
import com.example.ryuu_fit.pantallas.CurlBotellas
import com.example.ryuu_fit.pantallas.ElevacionLat
import com.example.ryuu_fit.pantallas.ElevacionTalones
import com.example.ryuu_fit.pantallas.ElevacionesLaterales
import com.example.ryuu_fit.pantallas.EstiramientoBrazos
import com.example.ryuu_fit.pantallas.EstiramientoBrazosCr
import com.example.ryuu_fit.pantallas.FlexPared
import com.example.ryuu_fit.pantallas.FlexPica
import com.example.ryuu_fit.pantallas.FlexionApoyandoRodillas
import com.example.ryuu_fit.pantallas.FlexionContraPared
import com.example.ryuu_fit.pantallas.FondoSilla
import com.example.ryuu_fit.pantallas.LoginScreen
import com.example.ryuu_fit.pantallas.TestInicialScreen
import com.example.ryuu_fit.pantallas.HomeScreen
import com.example.ryuu_fit.pantallas.MarchaActiva
import com.example.ryuu_fit.pantallas.MarchaSitio

//Rutas Johan
import com.example.ryuu_fit.pantallas.detallesEjercicio
import com.example.ryuu_fit.pantallas.detallesTraining
import com.example.ryuu_fit.pantallas.trainingWeek

//Rutas Julian
import com.example.ryuu_fit.pantallas.Nutricion
import com.example.ryuu_fit.pantallas.MenuScreen
import com.example.ryuu_fit.pantallas.PlanchaAntebrazos
import com.example.ryuu_fit.pantallas.PlanchaFrontal
import com.example.ryuu_fit.pantallas.PuenteGluteo
import com.example.ryuu_fit.pantallas.RemoToalla
import com.example.ryuu_fit.pantallas.Respiracion
import com.example.ryuu_fit.pantallas.SentadillaExten
import com.example.ryuu_fit.pantallas.SentadillasApoyo
import com.example.ryuu_fit.pantallas.SentadillasParciales
import com.example.ryuu_fit.pantallas.SupermanTumbado
import com.example.ryuu_fit.pantallas.lunes
import com.example.ryuu_fit.pantallas.martes
import com.example.ryuu_fit.pantallas.miercoles
import com.example.ryuu_fit.pantallas.sabado
import com.example.ryuu_fit.pantallas.viernes

//Rutas Jhon Quenan
import com.example.ryuu_fit.pantallas.DietaDesayuno
import com.example.ryuu_fit.pantallas.DietaMerienda
import com.example.ryuu_fit.pantallas.DietaAlmuerzo
import com.example.ryuu_fit.pantallas.DietaCena
import com.example.ryuu_fit.pantallas.DietaSnack


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

        composable(route = AppPantallas.Lunes.ruta){
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

        composable(route = AppPantallas.Sabado.ruta){
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

        composable(route = AppPantallas.LFondoSilas.ruta){
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

        composable(route = AppPantallas.MSuperman.ruta){
            SupermanTumbado(navController)
        }

        composable(route = AppPantallas.JElevacionLat.ruta) {
            ElevacionesLaterales(navController)
        }

        composable(route = AppPantallas.MiElevacionTal.ruta) {
            ElevacionTalones(navController)
        }

        composable(route = AppPantallas.MiMarchaSitio.ruta){
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

        composable(route = AppPantallas.JPlanchaFrontal.ruta){
            PlanchaFrontal(navController)
        }

        composable(route = AppPantallas.VFlexPared.ruta){
            FlexPared(navController)
        }

        composable(route = AppPantallas.VMarchaActiva.ruta) {
            MarchaActiva(navController)
        }

        composable(route = AppPantallas.VRespiracion.ruta) {
            Respiracion(navController)
        }

        composable(route = AppPantallas.VSentadillaExten.ruta){
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

        composable(route = AppPantallas.SSentadiApoyo.ruta){
            SentadillasApoyo(navController)
        }


        //Partes Julian

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

//Probando los pull request
//Intento 2 con pull request
// Se creo una nueva branch para probar el pull request
//Tercer intento con el correo institucional