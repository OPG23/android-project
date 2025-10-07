package com.example.ryuu_fit.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ryuu_fit.R

// Modelo de datos para cada ejercicio
data class Ejercicio(
    val nombre: String,
    val repeticiones: String,
    val imagen: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun detallesTraining(
    navController: NavController? = null, // Permite null para usarlo en el Preview
    dia: String = "Jueves",
    rutina: String = "Hombros y Core"
) {
    // Lista de ejercicios que se mostrarán
    val ejercicios = listOf(
        Ejercicio("Flexiones en Pica", "4×12", R.drawable.ic_launcher_foreground), // flexion_pica
        Ejercicio("Plancha Frontal", "3×45", R.drawable.ic_launcher_foreground), // plancha_frontal
        Ejercicio("Abdominales en Bicicleta", "3×20", R.drawable.ic_launcher_foreground), // abd_bici
        Ejercicio("Elevaciones Laterales", "3×12", R.drawable.ic_launcher_foreground) // elevaciones_laterales
    )

    // Estado para los checkboxes (true/false)
    val estados = remember { mutableStateListOf(*Array(ejercicios.size) { false }) }

    Scaffold(
        // Barra superior
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        dia,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController?.popBackStack() }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_backarrow),
                            contentDescription = "Volver atrás",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        containerColor = Color.Black,

        // Botón inferior
        bottomBar = {
            Button(
                onClick = { navController?.popBackStack() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .navigationBarsPadding()
            ) {
                Text("Finalizar entrenamiento")
            }
        }
    ) { paddingValues ->

        // Contenido principal con scroll
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Encabezado
            item {
                Text(
                    text = "Rutina",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ryuu_fit_image_bgrm),
                        contentDescription = "Logo Ryuu-Fit",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(end = 12.dp)
                    )
                    Text(
                        text = "Recuerda realizar tus ejercicios de forma pausada y con la mejor técnica posible, ¡DISFRUTA!",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

            // Lista de ejercicios
            itemsIndexed(ejercicios) { index, ejercicio ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Checkbox de progreso
                    Checkbox(
                        checked = estados[index],
                        onCheckedChange = { estados[index] = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Red,
                            uncheckedColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Información del ejercicio
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = ejercicio.nombre,
                            color = if (estados[index]) Color.Red else Color.White,
                            fontSize = 16.sp,
                            fontWeight = if (estados[index]) FontWeight.Bold else FontWeight.Normal
                        )
                        Text(
                            text = ejercicio.repeticiones,
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }

                    // Imagen del ejercicio
                    Image(
                        painter = painterResource(id = ejercicio.imagen),
                        contentDescription = ejercicio.nombre,
                        modifier = Modifier.size(80.dp)
                    )
                }
            }
        }
    }
}

// 🔍 Preview para ver cómo se verá la pantalla en Android Studio
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetallesPreview() {
    detallesTraining(
        dia = "Jueves",
        rutina = "Hombros y Core"
    )
}
