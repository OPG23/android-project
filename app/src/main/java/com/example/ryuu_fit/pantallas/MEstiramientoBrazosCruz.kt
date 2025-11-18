package com.example.ryuu_fit.pantallas

import androidx.compose.animation.AnimatedVisibility
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
//
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EstiramientoBrazosCr(
    navController: NavController? = null, //Hacemos opcional para que funcione el Preview
    dia: String = "Martes",
    ejercicio: String = "Estiramiento de brazos cruzados",
    repeticiones: String = "2x30 Seg.",
    imagen: Int = R.drawable.estiramiento_cruzado,
    descripcion: String = "Estira los hombros y la parte superior de la espalda, aliviando la tensión y mejorando la movilidad articular."
) {
    var serie by remember { mutableStateOf(1) }
    var isResting by remember { mutableStateOf(false) } // Indica si está en descanso
    var timeLeft by remember { mutableStateOf(30) } // Tiempo restante en segundos
    var showDetails by remember { mutableStateOf(false) } // Desplegable

    // Efecto que ejecuta el cronómetro cuando isResting es true
    LaunchedEffect(isResting) {
        if (isResting) {
            for (i in 30 downTo 1) {
                timeLeft = i
                delay(1000L)
            }
            // Cuando el tiempo llega a 0, avanza de serie y termina el descanso
            serie++
            isResting = false
            timeLeft = 30
        }
    }

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
                painter =  painterResource(id = imagen), // painter =  painterResource(id = imagen)
                contentDescription = "Imagen del ejercicio",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            //Boton desplegable para los detalles
            Button(
                onClick = { showDetails = !showDetails},
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text(
                    text = if (showDetails) "Ocultar detalles" else "Ver detalles",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            // Animacion para el desplegable
            AnimatedVisibility(visible = showDetails) {
                Text(
                    text = descripcion,
                    color = Color.LightGray,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    lineHeight = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            // Texto de progreso
            if (serie <= 2) {
                Text(
                    text = "${serie}/2",
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

            // Mostrar el cronómetro si está en descanso
            if (isResting && serie <= 2) {
                Text(
                    text = "Descanso: ${timeLeft}s",
                    color = Color.Red,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botón de control
            if (serie <= 2 && !isResting) {
                Button(
                    onClick = { isResting = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(
                        text = if (serie < 2) "Siguiente serie" else "Finalizar",
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
fun EstiramientoBrazosCrPreview() {
    // Se usa rememberNavController solo para vista previa
    val navController = rememberNavController()

    EstiramientoBrazosCr(
        navController = navController,
        dia = "Martes",
        ejercicio = "Estiramiento de brazos cruzados",
        repeticiones = "2x30 Seg.",
        imagen = R.drawable.estiramiento_cruzado // abd_bici
    )
}
