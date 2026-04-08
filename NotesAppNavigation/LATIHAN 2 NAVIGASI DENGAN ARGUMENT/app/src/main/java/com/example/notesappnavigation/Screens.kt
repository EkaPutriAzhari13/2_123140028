package com.example.notesappnavigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Warna-warna sesuai gambar
val BackgroundColor = Color(0xFFF0E1F9)
val PrimaryPink = Color(0xFFD81B60)
val SecondaryBrown = Color(0xFF7D5260)
val TextGray = Color(0xFF705D63)

@Composable
fun NoteListScreen(onNoteClick: (Int) -> Unit) {
    // Daftar ID catatan
    val notes = listOf(42, 43, 44)

    Surface(
        color = BackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Catatan Pinky",
                color = PrimaryPink,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Daftar Catatan Hari Ini",
                color = TextGray,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Menggunakan column biasa agar terpusat di tengah layar sesuai gambar
            notes.forEach { id ->
                Button(
                    onClick = { onNoteClick(id) },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryPink),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .height(48.dp)
                        .width(220.dp)
                ) {
                    Text("Buka Catatan #$id", color = Color.White, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}

@Composable
fun NoteDetailScreen(noteId: Int, onBack: () -> Unit) {
    Surface(
        color = BackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Detail Catatan",
                color = PrimaryPink,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            Text(
                text = "ID: $noteId",
                color = Color(0xFF880E4F), // Warna pink gelap
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 64.sp
                ),
                modifier = Modifier.padding(bottom = 48.dp)
            )
            
            Button(
                onClick = onBack,
                colors = ButtonDefaults.buttonColors(containerColor = SecondaryBrown),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .height(45.dp)
                    .width(150.dp)
            ) {
                Text("Kembali", color = Color.White)
            }
        }
    }
}
