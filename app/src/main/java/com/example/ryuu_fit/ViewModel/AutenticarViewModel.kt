package com.example.ryuu_fit.ViewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf

class UserPreferencesViewModel : ViewModel() {

    // días seleccionados (1..7)
    var diasEntreno = mutableStateOf(0)

    fun setDiasEntreno(valor: Int) {
        diasEntreno.value = valor
    }

    // función que devuelve la lista de pantallas según días
    fun pantallasParaDias(): List<String> {
        return when (diasEntreno.value) {
            2 -> listOf("lunes", "miercoles")
            3 -> listOf("lunes", "miercoles", "viernes")
            4 -> listOf("lunes", "martes", "jueves", "sabado")
            5 -> listOf("lunes", "martes", "miercoles", "jueves", "viernes")
            6 -> listOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado")
            else -> emptyList()
        }
    }
}
