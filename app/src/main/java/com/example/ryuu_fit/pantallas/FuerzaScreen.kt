package com.example.ryuu_fit.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.navigation.compose.rememberNavController
import com.example.ryuu_fit.R

// Modelo de datos para los ejercicios de fuerza
data class EjercicioFuerza(
    val nombre: String,
    val repeticiones: String,
    val imagen: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FuerzaScreen(
    onFinalizarClick: () -> Unit
) {
    // Lista de ejercicios SIN EQUIPO
    val ejercicios = listOf(
        EjercicioFuerza("Flexiones de Pecho (Push-Ups)", "4×15 rep", R.drawable.flexiones),
        EjercicioFuerza("Sentadillas (Squats)", "4×20 rep", R.drawable.sentadillas),
        EjercicioFuerza("Zancadas (Lunges)", "3×12 rep por pierna", R.drawable.zancadas),
        EjercicioFuerza("Planchas (Planks)", "3×45 seg", R.drawable.plancha_toques),
        EjercicioFuerza("Fondos entre Sillas (Triceps Dips)", "3×12 rep", R.drawable.puente_gluteos)
    )

    // Estado de los checkboxes (para marcar ejercicios completados)
    val estados = remember { mutableStateListOf(*Array(ejercicios.size) { false }) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Fuerza",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onFinalizarClick() }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_backarrow),
                            contentDescription = "Volver atrás",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        containerColor = Color.Black,
        bottomBar = {
            Button(
                onClick = { onFinalizarClick() },
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Encabezado de la pantalla
            item {
                Text(
                    text = "Rutina de Entrenamiento de Fuerza en Casa",
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
                        text = "Fortalece todo tu cuerpo con ejercicios básicos de fuerza que no requieren equipo. ¡Solo tu peso corporal y constancia!",
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
                    Checkbox(
                        checked = estados[index],
                        onCheckedChange = { estados[index] = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Red,
                            uncheckedColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.width(8.dp))

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FuerzaPreview() {
    FuerzaScreen(onFinalizarClick = {})
}