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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ryuu_fit.Navegacion.AppPantallas
import com.example.ryuu_fit.R
import com.example.ryuu_fit.ViewModel.TestViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun trainingWeek(
    navController: NavController,
    testViewModel: TestViewModel = viewModel()
) {
    // Observamos los días de entrenamiento desde el ViewModel
    val diasEntreno by testViewModel.diasEntreno.collectAsState()

    // Lista completa de días con sus rutinas
    val todosLosDias = listOf(
        "Lunes" to "Pecho y triceps",
        "Martes" to "Espalda y biceps",
        "Miércoles" to "Piernas y gluteos",
        "Jueves" to "Hombros y core",
        "Viernes" to "Full body",
        "Sábado" to "Piernas y core"
    )

    // Filtramos los días según la cantidad seleccionada
    val diasMostrar = remember(diasEntreno) {
        filtrarDiasPorCantidad(todosLosDias, diasEntreno ?: 3)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Rutina Semanal (${diasEntreno ?: 3} días)",
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_backarrow),
                            contentDescription = "Volver atrás",
                            tint = Color.Black
                        )
                    }
                }
            )
        },
        containerColor = Color.Black
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mensaje informativo
            if (diasEntreno == null) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1A1A1A)
                    )
                ) {
                    Text(
                        text = "⚠️ No has completado el test inicial. Mostrando rutina por defecto (3 días).",
                        color = Color.Yellow,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Mostramos solo los días filtrados
            diasMostrar.forEachIndexed { index, (dia, rutina) ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF000000),
                        contentColor = Color.White
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = dia,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = rutina
                            )
                        }
                        TextButton(
                            onClick = {
                                val ruta = when (dia) {
                                    "Lunes" -> AppPantallas.Lunes.ruta
                                    "Martes" -> AppPantallas.Martes.ruta
                                    "Miércoles" -> AppPantallas.Miercoles.ruta
                                    "Jueves" -> AppPantallas.DetallesTr.ruta
                                    "Viernes" -> AppPantallas.Viernes.ruta
                                    "Sábado" -> AppPantallas.Sabado.ruta
                                    else -> AppPantallas.Home.ruta
                                }
                                navController.navigate(ruta)
                            },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text("Ver más", color = Color.Red)
                        }
                    }
                }

                if (index < diasMostrar.lastIndex) {
                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = painterResource(id = R.drawable.ryuu_fit_image_bgrm),
                contentDescription = "Logo Ryuu-Fit",
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text("Terminar circuito")
            }
        }
    }
}

/**
 * Función que filtra los días de entrenamiento según la cantidad seleccionada
 */
fun filtrarDiasPorCantidad(
    todosLosDias: List<Pair<String, String>>,
    cantidad: Int
): List<Pair<String, String>> {
    return when (cantidad) {
        1 -> listOf(todosLosDias[0]) // Lunes

        2 -> listOf(
            todosLosDias[0], // Lunes
            todosLosDias[3]  // Jueves
        )

        3 -> listOf(
            todosLosDias[0], // Lunes
            todosLosDias[2], // Miércoles
            todosLosDias[4]  // Viernes
        )

        4 -> listOf(
            todosLosDias[0], // Lunes
            todosLosDias[1], // Martes
            todosLosDias[3], // Jueves
            todosLosDias[4]  // Viernes
        )

        5 -> listOf(
            todosLosDias[0], // Lunes
            todosLosDias[1], // Martes
            todosLosDias[2], // Miércoles
            todosLosDias[3], // Jueves
            todosLosDias[4]  // Viernes
        )

        6 -> listOf(
            todosLosDias[0], // Lunes
            todosLosDias[1], // Martes
            todosLosDias[2], // Miércoles
            todosLosDias[3], // Jueves
            todosLosDias[4], // Viernes
            todosLosDias[5]  // Sábado
        )

        else -> listOf(
            todosLosDias[0], // Por defecto: Lunes, Miércoles, Viernes
            todosLosDias[2],
            todosLosDias[4]
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RutinaPreview() {
    val navController = rememberNavController()
    trainingWeek(navController)
}