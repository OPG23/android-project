package com.example.ryuu_fit.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ryuu_fit.Navegacion.AppPantallas
import com.example.ryuu_fit.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
) {
    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                NavigationBarItem(
                    selected = true,
                    onClick = { navController.popBackStack() },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "Home",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Inicio") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(AppPantallas.TrainingWeek.ruta) },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_rutinas),
                            contentDescription = "Rutinas",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Rutinas") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.popBackStack() },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_notificaciones),
                            contentDescription = "Notificaciones",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Alertas") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(AppPantallas.Menu.ruta) },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_perfil),
                            contentDescription = "Perfil",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Perfil") }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Barra de búsqueda
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Buscar", color = Color.Gray) },
                leadingIcon = {
                    Image(
                        painter = painterResource(R.drawable.ryuu_fit_image_bgrm),
                        contentDescription = "Buscar",
                        modifier = Modifier.size(24.dp)
                    )
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Chips
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FilterChip("Avances", onClick = { navController.navigate(AppPantallas.DetallesEx.ruta) })
                FilterChip("Rutinas", onClick = { navController.navigate(AppPantallas.TrainingWeek.ruta) })
                FilterChip("Nutrición", onClick = { navController.navigate(AppPantallas.Nutricion.ruta) })
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Logo
            Image(
                painter = painterResource(id = R.drawable.ryuu_fit_image_bgrm),
                contentDescription = "Logo",
                modifier = Modifier.size(180.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Fila de categorías - 🔥 AQUÍ SE CONECTAN LOS BOTONES
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CategoryIcon(
                    iconRes = R.drawable.ic_cardio,
                    label = "Cardio",
                    onClick = { navController.navigate(AppPantallas.Cardio.ruta) }
                )
                CategoryIcon(
                    iconRes = R.drawable.ic_fuerza,
                    label = "Fuerza",
                    onClick = { navController.navigate(AppPantallas.Fuerza.ruta) }
                )
                CategoryIcon(
                    iconRes = R.drawable.ic_resistencia,
                    label = "Resistencia",
                    onClick = { navController.navigate(AppPantallas.Resistencia.ruta) }
                )
                CategoryIcon(
                    iconRes = R.drawable.ic_elasticidad,
                    label = "Elasticidad",
                    onClick = { navController.navigate(AppPantallas.Elasticidad.ruta) }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Opciones con imágenes
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OptionCard(
                    R.drawable.ic_actuinfo,
                    "Actualización de información",
                    onClick = { navController.navigate(AppPantallas.Test.ruta) }
                )
                OptionCard(
                    R.drawable.ic_opcidietas,
                    "Opciones de dietas",
                    onClick = { navController.navigate(AppPantallas.Nutricion.ruta) }
                )
            }
        }
    }
}

@Composable
fun FilterChip(text: String, onClick: () -> Unit = {}) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color.DarkGray,
        modifier = Modifier.clickable { onClick() }
    ) {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            fontSize = 14.sp
        )
    }
}

@Composable
fun CategoryIcon(iconRes: Int, label: String, onClick: () -> Unit = {}) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Surface(
            modifier = Modifier.size(64.dp),
            shape = CircleShape,
            color = Color.Transparent,
            tonalElevation = 2.dp
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier.padding(12.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            label,
            color = Color.White,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OptionCard(imageRes: Int, text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .background(Color.DarkGray, RoundedCornerShape(8.dp))
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val fakeNavController = androidx.navigation.compose.rememberNavController()
    com.example.ryuu_fit.ui.theme.RYUU_FITTheme {
        HomeScreen(navController = fakeNavController)
    }
}