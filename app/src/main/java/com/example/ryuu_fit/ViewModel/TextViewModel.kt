package com.example.ryuu_fit.ViewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TestViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences = application.getSharedPreferences(
        "ryuu_fit_prefs",
        Context.MODE_PRIVATE
    )

    private val _diasEntreno = MutableStateFlow<Int?>(null)
    val diasEntreno = _diasEntreno.asStateFlow()

    init {
        // Cargar el valor guardado al iniciar
        cargarDiasEntreno()
    }

    fun setDiasEntreno(dias: Int) {
        _diasEntreno.value = dias

        // Guardar en SharedPreferences
        viewModelScope.launch {
            sharedPreferences.edit().apply {
                putInt("dias_entreno", dias)
                apply()
            }
        }
    }

    private fun cargarDiasEntreno() {
        val dias = sharedPreferences.getInt("dias_entreno", -1)
        if (dias != -1) {
            _diasEntreno.value = dias
        }
    }

    // Función para resetear los datos
    fun resetearDatos() {
        _diasEntreno.value = null
        sharedPreferences.edit().clear().apply()
    }
}

// Factory para crear el ViewModel con Application context
class TestViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TestViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}