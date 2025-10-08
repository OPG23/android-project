package com.example.ryuu_fit.Navegacion

sealed class AppPantallas(val ruta: String) {
    object Login: AppPantallas("login")
    object Home: AppPantallas("home")
    object Test: AppPantallas("test")


    //Parte de Johan
    object DetallesTr: AppPantallas("detallesTr")

    object DetallesEx: AppPantallas("detallesEx")

    object TrainingWeek: AppPantallas("trainingWeek")

    //Julian Pantallas
    object Rutina : AppPantallas("rutina")

    object Menu : AppPantallas("menu")


}