package com.example.ryuu_fit.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.navigation.compose.rememberNavController
import com.example.ryuu_fit.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun detallesEjercicio(
    navController: NavController? = null, // Hacemos opcional para que funcione el Preview
    dia: String = "Jueves",
    ejercicio: String = "Abdominales en bicicleta",
    repeticiones: String = "3x20",
    imagen: Int = R.drawable.ic_launcher_foreground // abd_bici
) {
    // Estado de la serie actual
    var serie by remember { mutableStateOf(1) }

    Scaffold(
        // Barra superior
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = dia, color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = { navController?.popBackStack() }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_backarrow),
                            contentDescription = "Volver",
                            tint = Color.Black // Flecha negra
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        containerColor = Color.Black
    ) { paddingValues ->
        // Contenedor principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Nombre del ejercicio
            Text(
                text = ejercicio,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            // Repeticiones
            Text(
                text = repeticiones,
                color = Color.Gray,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Logo o imagen decorativa
            Image(
                painter = painterResource(id = R.drawable.ryuu_fit_image_bgrm),
                contentDescription = "Logo Ryuu-Fit",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Imagen del ejercicio
            Image(
                painter = painterResource(id = imagen),
                contentDescription = "Imagen del ejercicio",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Texto de progreso
            if (serie <= 3) {
                Text(
                    text = "${serie}/3",
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text(
                    text = "Ejercicio Completado",
                    color = Color.Red,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                // Al completar vuelve atrás después de 1 segundo
                LaunchedEffect(Unit) {
                    delay(1000)
                    navController?.popBackStack()
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botón siguiente serie
            if (serie <= 3) {
                Button(
                    onClick = { serie++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(
                        text = if (serie < 3) "Siguiente serie" else "Finalizar",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

// 🔍 Preview funcional en Android Studio
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetallesEjercicioPreview() {
    // Se usa rememberNavController solo para vista previa
    val navController = rememberNavController()

    detallesEjercicio(
        navController = navController,
        dia = "Jueves",
        ejercicio = "Abdominales en bicicleta",
        repeticiones = "3x20",
        imagen = R.drawable.ic_launcher_foreground // abd_bici
    )
}
