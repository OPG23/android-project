package com.example.ryuu_fit.`pantallas-2`

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
import com.example.ryuu_fit.R
import com.example.ryuu_fit.Navegacion.AppPantallas

data class EjercicioElasticidad(
    val nombre: String,
    val repeticiones: String,
    val imagen: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElasticidadScreen(

    navController: NavController? = null,
    dia: String = "Elasticidad",
    rutina: String = "Elasticidad y Movilidad",
    onFinalizarClick: (() -> Unit)? = null //
) {
    val ejercicios = listOf(
        EjercicioElasticidad("Estiramiento de Espalda y Brazos", "3×30 seg", R.drawable.elasticidad_espalda),
        EjercicioElasticidad("Estiramiento de Piernas Sentado", "3×30 seg", R.drawable.elasticidad_piernas),
        EjercicioElasticidad("Giro de Tronco de Pie", "3×20", R.drawable.elasticidad_tronco),
        EjercicioElasticidad("Rotación de Caderas", "3×20", R.drawable.elasticidad_caderas),
        EjercicioElasticidad("Perro Boca Abajo (Yoga)", "3×40 seg", R.drawable.elasticidad_perro)
    )

    // Estados de selección de ejercicios
    val estados = remember { mutableStateListOf(*Array(ejercicios.size) { false }) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = dia,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController?.navigate(AppPantallas.Home.ruta) }) {
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
                onClick = { onFinalizarClick?.invoke() ?: navController?.navigate(AppPantallas.Home.ruta) },
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
            item {
                Text(
                    text = "Rutina de $rutina",
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
                        text = "Mejora tu movilidad y flexibilidad con estiramientos suaves que reducen la tensión muscular y mejoran tu postura.",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

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
fun ElasticidadPreview() {
    ElasticidadScreen()
}
