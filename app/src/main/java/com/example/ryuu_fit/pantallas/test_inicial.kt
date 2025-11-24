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

// --------------------
// MODELO PREGUNTA
// --------------------

data class Pregunta(
    val label: String,
    val opciones: List<String>
)

// --------------------
// LISTA DE PREGUNTAS
// --------------------

val preguntasParte1 = listOf(
    Pregunta("Edad", (15..100).map { "$it años" }),
    Pregunta("Altura (Cm)", (100..200).map { "$it cm" }),
    Pregunta("Peso (Kg)", (30..200).map { "$it kg" }),
    Pregunta("Género", listOf("Masculino", "Femenino", "Otro")),
    Pregunta("Complexión corporal", listOf("Delgada", "Media", "Musculosa", "Robusta")),
    Pregunta("Frecuencia de actividad física", listOf("Nunca", "1-2 veces/semana", "3-5 veces/semana", "Diario")),
    Pregunta("Nivel de condición física", listOf("Bajo", "Medio", "Alto")),
    Pregunta("Objetivo principal", listOf("Bajar de peso", "Ganar masa muscular", "Mantenerme en forma", "Otro")),
    Pregunta("Qué tiempo diario entrenarías", listOf("15 min", "30 min", "45 min", "1h", "Más de 1h")),
    Pregunta("Cuántos días a la semana entrenarías", (1..6).map { "$it días" }),
    Pregunta("Tienes restricciones alimenticias", listOf("Ninguna", "Vegetariano", "Vegano", "Sin gluten", "Otra")),
    Pregunta("Frecuencia consumo de comidas rápidas", listOf("Nunca", "1 vez/semana", "2-3 veces/semana", "Más de 3 veces/semana"))
)

val preguntasParte2 = listOf(
    Pregunta("Cuántas horas sueles dormir", (4..12).map { "$it horas" }),
    Pregunta("Qué te motiva a entrenar", listOf("Salud", "Estética", "Rendimiento deportivo", "Otro")),
    Pregunta("Quieres recibir notificaciones", listOf("Sí", "No"))
)

// --------------------------
// PANTALLA DEL TEST INICIAL
// --------------------------

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

            // -----------------------------
            // PARTE 1
            // -----------------------------
            if (parte == 1) {

                preguntasParte1.forEach { pregunta ->

                    DropdownField(
                        label = pregunta.label,
                        options = pregunta.opciones,
                        onValueSelected = { value ->

                            // Detectamos la pregunta de los días
                            if (pregunta.label == "Cuántos días a la semana entrenarías") {

                                val dias = value.split(" ")[0].toInt() // "4 días" → 4
                                testViewModel.setDiasEntreno(dias)
                            }
                        }
                    )
                }

            } else {

                // -----------------------------
                // PARTE 2
                // -----------------------------
                preguntasParte2.forEach { pregunta ->
                    DropdownField(pregunta.label, pregunta.opciones)
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

// --------------------------
// DROPDOWN COMPONENTE
// --------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownField(
    label: String,
    options: List<String>,
    onValueSelected: (String) -> Unit = {}
) {

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("seleccione el rango") }

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
            modifier = Modifier.menuAnchor().fillMaxWidth()
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
                        onValueSelected(option)   // 🔥 ENVÍA EL VALOR SELECCIONADO
                        expanded = false
                    }
                )
            }
        }
    }
}
