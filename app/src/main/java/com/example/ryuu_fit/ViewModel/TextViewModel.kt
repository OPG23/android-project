package com.example.ryuu_fit.ViewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class DatosUsuario(
    val edad: Int? = null,
    val altura: Int? = null,
    val peso: Int? = null,
    val genero: String? = null,
    val complexion: String? = null,
    val frecuenciaActividad: String? = null,
    val nivelCondicion: String? = null,
    val objetivoPrincipal: String? = null,
    val tiempoDisponible: String? = null,
    val diasEntreno: Int? = null,
    val restriccionesAlimenticias: String? = null,
    val frecuenciaComidaRapida: String? = null,
    val horasSueno: Int? = null,
    val motivacion: String? = null,
    val notificaciones: Boolean = true
)

class TestViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences = application.getSharedPreferences(
        "ryuu_fit_prefs",
        Context.MODE_PRIVATE
    )

    private val _datosUsuario = MutableStateFlow(DatosUsuario())
    val datosUsuario = _datosUsuario.asStateFlow()

    // Flow específico para días de entreno (para compatibilidad con código existente)
    private val _diasEntreno = MutableStateFlow<Int?>(null)
    val diasEntreno = _diasEntreno.asStateFlow()

    init {
        cargarDatosUsuario()
    }

    // Función para actualizar un campo específico
    fun actualizarDato(campo: String, valor: Any) {
        val datosActuales = _datosUsuario.value

        val datosNuevos = when (campo) {
            "edad" -> datosActuales.copy(edad = valor as? Int)
            "altura" -> datosActuales.copy(altura = valor as? Int)
            "peso" -> datosActuales.copy(peso = valor as? Int)
            "genero" -> datosActuales.copy(genero = valor as? String)
            "complexion" -> datosActuales.copy(complexion = valor as? String)
            "frecuenciaActividad" -> datosActuales.copy(frecuenciaActividad = valor as? String)
            "nivelCondicion" -> datosActuales.copy(nivelCondicion = valor as? String)
            "objetivoPrincipal" -> datosActuales.copy(objetivoPrincipal = valor as? String)
            "tiempoDisponible" -> datosActuales.copy(tiempoDisponible = valor as? String)
            "diasEntreno" -> {
                val dias = valor as? Int
                _diasEntreno.value = dias
                datosActuales.copy(diasEntreno = dias)
            }
            "restriccionesAlimenticias" -> datosActuales.copy(restriccionesAlimenticias = valor as? String)
            "frecuenciaComidaRapida" -> datosActuales.copy(frecuenciaComidaRapida = valor as? String)
            "horasSueno" -> datosActuales.copy(horasSueno = valor as? Int)
            "motivacion" -> datosActuales.copy(motivacion = valor as? String)
            "notificaciones" -> datosActuales.copy(notificaciones = valor as? Boolean ?: true)
            else -> datosActuales
        }

        _datosUsuario.value = datosNuevos
        guardarDatosUsuario(datosNuevos)
    }

    // Función legacy para compatibilidad
    fun setDiasEntreno(dias: Int) {
        actualizarDato("diasEntreno", dias)
    }

    private fun guardarDatosUsuario(datos: DatosUsuario) {
        viewModelScope.launch {
            sharedPreferences.edit().apply {
                datos.edad?.let { putInt("edad", it) }
                datos.altura?.let { putInt("altura", it) }
                datos.peso?.let { putInt("peso", it) }
                datos.genero?.let { putString("genero", it) }
                datos.complexion?.let { putString("complexion", it) }
                datos.frecuenciaActividad?.let { putString("frecuencia_actividad", it) }
                datos.nivelCondicion?.let { putString("nivel_condicion", it) }
                datos.objetivoPrincipal?.let { putString("objetivo_principal", it) }
                datos.tiempoDisponible?.let { putString("tiempo_disponible", it) }
                datos.diasEntreno?.let { putInt("dias_entreno", it) }
                datos.restriccionesAlimenticias?.let { putString("restricciones_alimenticias", it) }
                datos.frecuenciaComidaRapida?.let { putString("frecuencia_comida_rapida", it) }
                datos.horasSueno?.let { putInt("horas_sueno", it) }
                datos.motivacion?.let { putString("motivacion", it) }
                putBoolean("notificaciones", datos.notificaciones)
                apply()
            }
        }
    }

    private fun cargarDatosUsuario() {
        val edad = sharedPreferences.getInt("edad", -1).takeIf { it != -1 }
        val altura = sharedPreferences.getInt("altura", -1).takeIf { it != -1 }
        val peso = sharedPreferences.getInt("peso", -1).takeIf { it != -1 }
        val diasEntreno = sharedPreferences.getInt("dias_entreno", -1).takeIf { it != -1 }
        val horasSueno = sharedPreferences.getInt("horas_sueno", -1).takeIf { it != -1 }

        _datosUsuario.value = DatosUsuario(
            edad = edad,
            altura = altura,
            peso = peso,
            genero = sharedPreferences.getString("genero", null),
            complexion = sharedPreferences.getString("complexion", null),
            frecuenciaActividad = sharedPreferences.getString("frecuencia_actividad", null),
            nivelCondicion = sharedPreferences.getString("nivel_condicion", null),
            objetivoPrincipal = sharedPreferences.getString("objetivo_principal", null),
            tiempoDisponible = sharedPreferences.getString("tiempo_disponible", null),
            diasEntreno = diasEntreno,
            restriccionesAlimenticias = sharedPreferences.getString("restricciones_alimenticias", null),
            frecuenciaComidaRapida = sharedPreferences.getString("frecuencia_comida_rapida", null),
            horasSueno = horasSueno,
            motivacion = sharedPreferences.getString("motivacion", null),
            notificaciones = sharedPreferences.getBoolean("notificaciones", true)
        )

        _diasEntreno.value = diasEntreno
    }

    fun resetearDatos() {
        _datosUsuario.value = DatosUsuario()
        _diasEntreno.value = null
        sharedPreferences.edit().clear().apply()
    }

    // Función para obtener días de la semana según cantidad
    fun obtenerDiasSemana(): String {
        return when (_datosUsuario.value.diasEntreno) {
            1 -> "L"
            2 -> "L J"
            3 -> "L M V"
            4 -> "L M J V"
            5 -> "L M M J V"
            6 -> "L M M J V S"
            else -> "No definido"
        }
    }
}

// Factory permanece igual
class TestViewModelFactory(
    private val application: Application
) : androidx.lifecycle.ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TestViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}