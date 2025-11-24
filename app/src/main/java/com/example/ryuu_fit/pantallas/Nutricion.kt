package com.example.ryuu_fit.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ryuu_fit.R
//
@Composable
fun Nutricion (onSalirClick: () -> Unit, onNavigateTo: (String) -> Unit,
               navController: NavController? = null
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Nutrición",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            val opciones = listOf(
                "Desayuno" to "dieta_desayuno",
                "Merienda" to "dieta_merienda",
                "Almuerzo" to "dieta_almuerzo",
                "Cena" to "dieta_cena",
                "Snack Nocturno" to "dieta_snack"
            )

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                opciones.forEach { (nombre, ruta) ->
                    Button(
                        onClick = { onNavigateTo(ruta) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                    ) {
                        Text(nombre, color = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Logo y botón salir
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.ryuu_fit_image_bgrm),
                    contentDescription = "Logo",
                    modifier = Modifier.size(90.dp),
                    contentScale = ContentScale.Fit
                )

                Button(
                    onClick = onSalirClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Salir", color = Color.Black)
                }
            }
        }
    }
}
