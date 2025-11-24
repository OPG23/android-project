package com.example.ryuu_fit.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ryuu_fit.R
import com.example.ryuu_fit.ViewModel.TestViewModel

data class Pregunta(
    val label: String,
    val opciones: List<String>,
    val campo: String
)

val preguntasParte1 = listOf(
    Pregunta("Edad", (15..100).map { "$it años" }, "edad"),
    Pregunta("Altura (Cm)", (100..200).map { "$it cm" }, "altura"),
    Pregunta("Peso (Kg)", (30..200).map { "$it kg" }, "peso"),
    Pregunta("Género", listOf("Masculino", "Femenino", "Otro"), "genero"),
    Pregunta("Complexión corporal", listOf("Delgada", "Media", "Musculosa", "Robusta"), "complexion"),
    Pregunta("Frecuencia de actividad física", listOf("Nunca", "1-2 veces/semana", "3-5 veces/semana", "Diario"), "frecuenciaActividad"),
    Pregunta("Nivel de condición física", listOf("Bajo", "Medio", "Alto"), "nivelCondicion"),
    Pregunta("Objetivo principal", listOf("Bajar de peso", "Ganar masa muscular", "Mantenerme en forma", "Otro"), "objetivoPrincipal"),
    Pregunta("Qué tiempo diario entrenarías", listOf("15 min", "30 min", "45 min", "1h", "Más de 1h"), "tiempoDisponible"),
    Pregunta("Cuántos días a la semana entrenarías", (1..6).map { "$it días" }, "diasEntreno"),
    Pregunta("Tienes restricciones alimenticias", listOf("Ninguna", "Vegetariano", "Vegano", "Sin gluten", "Otra"), "restriccionesAlimenticias"),
    Pregunta("Frecuencia consumo de comidas rápidas", listOf("Nunca", "1 vez/semana", "2-3 veces/semana", "Más de 3 veces/semana"), "frecuenciaComidaRapida")
)

val preguntasParte2 = listOf(
    Pregunta("Cuántas horas sueles dormir", (4..12).map { "$it horas" }, "horasSueno"),
    Pregunta("Qué te motiva a entrenar", listOf("Salud", "Estética", "Rendimiento deportivo", "Otro"), "motivacion"),
    Pregunta("Quieres recibir notificaciones", listOf("Sí", "No"), "notificaciones")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestInicialScreen(navController: NavController, testViewModel: TestViewModel = viewModel()) {

    var parte by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Test Inicial", color = Color.White, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_backarrow),
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Black)
            )
        },
        containerColor = Color.Black,
        bottomBar = {
            Button(
                onClick = {
                    if (parte == 1) parte = 2
                    else navController.navigate("home")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = if (parte == 1) "Siguiente" else "Terminar",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.Black)
                .padding(16.dp)
        ) {

            if (parte == 1) {
                preguntasParte1.forEach { pregunta ->
                    DropdownField(
                        label = pregunta.label,
                        options = pregunta.opciones,
                        onValueSelected = { value ->
                            procesarRespuesta(pregunta.campo, value, testViewModel)
                        }
                    )
                }
            } else {
                preguntasParte2.forEach { pregunta ->
                    DropdownField(
                        label = pregunta.label,
                        options = pregunta.opciones,
                        onValueSelected = { value ->
                            procesarRespuesta(pregunta.campo, value, testViewModel)
                        }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Image(
                    painter = painterResource(id = R.drawable.ryuu_fit_image_bgrm),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxWidth().height(150.dp).align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "RYUU-FIT",
                    color = Color.Red,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

// Función para procesar y guardar respuestas
fun procesarRespuesta(campo: String, valor: String, viewModel: TestViewModel) {
    when (campo) {
        "edad" -> {
            val edad = valor.split(" ")[0].toIntOrNull()
            edad?.let { viewModel.actualizarDato("edad", it) }
        }
        "altura" -> {
            val altura = valor.split(" ")[0].toIntOrNull()
            altura?.let { viewModel.actualizarDato("altura", it) }
        }
        "peso" -> {
            val peso = valor.split(" ")[0].toIntOrNull()
            peso?.let { viewModel.actualizarDato("peso", it) }
        }
        "diasEntreno" -> {
            val dias = valor.split(" ")[0].toIntOrNull()
            dias?.let { viewModel.actualizarDato("diasEntreno", it) }
        }
        "horasSueno" -> {
            val horas = valor.split(" ")[0].toIntOrNull()
            horas?.let { viewModel.actualizarDato("horasSueno", it) }
        }
        "notificaciones" -> {
            val notif = valor == "Sí"
            viewModel.actualizarDato("notificaciones", notif)
        }
        else -> {
            // Para strings directos
            viewModel.actualizarDato(campo, valor)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownField(
    label: String,
    options: List<String>,
    onValueSelected: (String) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Seleccione una opción") }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            label = { Text(label, color = Color.White) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor().fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.DarkGray,
                focusedContainerColor = Color.DarkGray,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedText = option
                        onValueSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
}