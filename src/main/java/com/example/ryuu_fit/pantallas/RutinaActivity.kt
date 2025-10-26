package com.example.ryuu_fit.pantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ryuu_fit.R // ← IMPORT AGREGADO

class RutinaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RutinaScreen(
                onSalirClick = {
                    finish()
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RutinaScreen(
    onSalirClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Título
            Text(
                text = "Rutina Semanal",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

            // Lista de comidas
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                val meals = listOf(
                    "Desayuno",
                    "Meriena",
                    "Almuerzo",
                    "Merienda",
                    "Cena",
                    "Snack Nocturno"
                )

                meals.forEach { meal ->
                    MealItem(meal = meal)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            // Logo y botón salir
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Logo en la parte inferior - USANDO IMAGEN EXISTENTE
                Image(
                    painter = painterResource(id = R.drawable.ryuu_fit_image), // ← IMAGEN QUE SÍ EXISTE
                    contentDescription = "Logo Ryuu Fit",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(vertical = 16.dp)
                )

                Text(
                    text = "RYUU-FIT",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Botón salir
                Button(
                    onClick = onSalirClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "sair",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Composable
fun MealItem(meal: String) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF333333),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = meal,
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RutinaScreenPreview() {
    RutinaScreen(
        onSalirClick = {}
    )
}