package com.example.ryuu_fit.Navegacion

sealed class AppPantallas(val ruta: String) {
    object Login: AppPantallas("login")
    object Home: AppPantallas("home")
    object Test: AppPantallas("test")


    //Parte de Johan

    object Lunes: AppPantallas("lunes")
    object Martes: AppPantallas("martes")
    object Miercoles: AppPantallas("miercoles")
    object DetallesTr: AppPantallas("detallesTr")
    object Viernes: AppPantallas("viernes")
    object Sabado: AppPantallas("sabado")
    object LEstiramientoBr: AppPantallas("estiramientoBr")
    object LFlexApoyandoRod: AppPantallas("flexApoyandoRod")
    object LFlexContraPar: AppPantallas("flexContraPar")
    object LFondoSilas: AppPantallas("fondoSillas")
    object MCurlBotellas: AppPantallas("curlBotellas")
    object MEstiramientoBrazos: AppPantallas("estiramientoBrazos")
    object MRemoToalla: AppPantallas("remoToallas")
    object MSuperman: AppPantallas("superman")
    object MiElevacionTal: AppPantallas("elevacionTal")
    object MiMarchaSitio: AppPantallas("marchaSitio")
    object MiPuenteGluteo: AppPantallas("puenteGluteo")
    object MISentadillasPar: AppPantallas("sentadillasPar")
    object DetallesEx: AppPantallas("detallesEx")
    object JElevacionLat: AppPantallas("elevacionLat")
    object JFlexPica: AppPantallas("flexPica")
    object JPlanchaFrontal: AppPantallas("planchaFrontal")
    object VFlexPared: AppPantallas("flexPared")
    object VMarchaActiva: AppPantallas("marchaActiva")
    object VRespiracion: AppPantallas("respiracion")
    object VSentadillaExten: AppPantallas("sentadillaExten")
    object SAbdomCortos: AppPantallas("abdomCortos")
    object SElevacionLatPier: AppPantallas("elevacionLatPier")
    object SPlanchaAnteb: AppPantallas("planchaAnteb")
    object SSentadiApoyo: AppPantallas("sentadillasApoyo")
    object TrainingWeek: AppPantallas("trainingWeek")

    //Julian Pantallas
    object Nutricion : AppPantallas("nutricion")
    object Rutina : AppPantallas("rutina")
    object Cardio : AppPantallas("cardio")
    object Fuerza : AppPantallas("fuerza")
    object Resistencia : AppPantallas("resistencia")
    object Elasticidad : AppPantallas("elasticidad")


    object Menu : AppPantallas("menu")


}