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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ryuu_fit.R
//
@Composable
fun DietaAlmuerzo(onBack: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Dieta - Almuerzo", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.almuerzo),
                contentDescription = "Almuerzo",
                modifier = Modifier.height(200.dp).fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = """
                    Pechuga a la plancha.
                    Ensalada verde con aguacate.
                    Arroz integral o quinoa.
                """.trimIndent(),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onBack) { Text("Volver") }
        }
    }
}
