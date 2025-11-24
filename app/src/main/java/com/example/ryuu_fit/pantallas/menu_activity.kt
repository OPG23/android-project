package com.example.ryuu_fit.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ryuu_fit.Navegacion.AppPantallas
import com.example.ryuu_fit.R
import com.example.ryuu_fit.ViewModel.TestViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    onSalirClick: (() -> Unit),
    onNavigateTo: ((String) -> Unit),
    testViewModel: TestViewModel = viewModel()
) {
    // Observar los datos del usuario
    val datosUsuario by testViewModel.datosUsuario.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.ryuu_fit_image_bgrm),
                contentDescription = "Logo Ryuu Fit",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 16.dp)
            )

            // Mensaje de bienvenida
            Text(
                text = "¡Bienvenido ahora vamos a cambiar tu vida!",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Datos del usuario dinámicos

            // Card 1: Peso e información física
            if (datosUsuario.peso != null || datosUsuario.objetivoPrincipal != null) {
                UserDataCard(
                    buildString {
                        datosUsuario.peso?.let { append("Peso Actual: $it Kg") }
                        datosUsuario.objetivoPrincipal?.let {
                            if (isNotEmpty()) append(" • ")
                            append("Objetivo: $it")
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Card 2: Días de entrenamiento
            if (datosUsuario.diasEntreno != null) {
                UserDataCard(
                    "Días semanales para ejercitarse: ${testViewModel.obtenerDiasSemana()}"
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Card 3: Tiempo disponible
            if (datosUsuario.tiempoDisponible != null) {
                UserDataCard(
                    "Tiempo diario para ejercicio: ${datosUsuario.tiempoDisponible}"
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Card adicional: Información extra (opcional)
            if (datosUsuario.nivelCondicion != null || datosUsuario.edad != null) {
                UserDataCard(
                    buildString {
                        datosUsuario.edad?.let { append("Edad: $it años") }
                        datosUsuario.nivelCondicion?.let {
                            if (isNotEmpty()) append(" • ")
                            append("Nivel: $it")
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Mensaje si no hay datos
            if (datosUsuario.diasEntreno == null) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF8B0000))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "⚠️ No has completado el test inicial",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Completa el test para personalizar tu experiencia",
                            color = Color.White,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(
                            onClick = { onNavigateTo(AppPantallas.Test.ruta) },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                        ) {
                            Text("Hacer Test Inicial", color = Color.Black)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón Rutina semanal
            Card(
                onClick = {
                    onNavigateTo(AppPantallas.TrainingWeek.ruta)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rutina_semanal),
                        contentDescription = "Rutina semanal",
                        modifier = Modifier.fillMaxSize()
                    )
                    Text(
                        text = "Rutina Semanal",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black.copy(alpha = 0.7f))
                            .padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón Plan alimenticio
            Card(
                onClick = {
                    onNavigateTo(AppPantallas.Nutricion.ruta)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF333333))
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plan_alimenticio),
                        contentDescription = "Plan alimenticio",
                        modifier = Modifier.fillMaxSize()
                    )
                    Text(
                        text = "Plan Alimenticio",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black.copy(alpha = 0.7f))
                            .padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para actualizar datos
            if (datosUsuario.diasEntreno != null) {
                OutlinedButton(
                    onClick = { onNavigateTo(AppPantallas.Test.ruta) },
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Actualizar Información")
                }
            }

            // Botón inferior
            Button(
                onClick = { onSalirClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .navigationBarsPadding()
            ) {
                Text("Volver")
            }
        }
    }
}

@Composable
fun UserDataCard(text: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF333333))
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun MenuScreenPreview() {
    MenuScreen(onSalirClick = {}, onNavigateTo = {})
}