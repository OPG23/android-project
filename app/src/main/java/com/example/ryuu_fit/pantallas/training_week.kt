package com.example.ryuu_fit.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ryuu_fit.Navegacion.AppPantallas
import com.example.ryuu_fit.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun trainingWeek(navController: NavController) {
    val dias = listOf(
        "Lunes" to "Pecho y triceps",
        "Martes" to "Espalda y biceps",
        "Miércoles" to "Piernas y gluteos",
        "Jueves" to "Hombros y core",
        "Viernes" to "Full body",
        "Sábado" to "Piernas y core"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Rutina Semanal", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = { navController?.popBackStack() }) {
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
            dias.forEachIndexed { index, (dia, rutina) ->

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
                                navController.navigate(AppPantallas.DetallesTr.ruta)
                            },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text("Ver más", color = Color.Red)
                        }
                    }
                }

                if (index < dias.lastIndex) {
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
                onClick = { navController?.popBackStack() }, // vuelve atrás al terminar
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RutinaPreview() {
    val navController = rememberNavController()
    trainingWeek(navController)
}