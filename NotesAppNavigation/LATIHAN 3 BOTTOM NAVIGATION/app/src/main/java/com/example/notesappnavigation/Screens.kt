package com.example.notesappnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesappnavigation.ui.theme.*

@Composable
fun NoteListScreen(onNoteClick: (Int) -> Unit) {
    val notes = listOf(42, 43, 44) // Mengikuti contoh di gambar
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkyBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "Catatan Pinky",
            style = MaterialTheme.typography.headlineLarge,
            color = PinkyTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
        Text(
            text = "Daftar Catatan Hari Ini",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(notes) { id ->
                Button(
                    onClick = { onNoteClick(id) },
                    colors = ButtonDefaults.buttonColors(containerColor = PinkyButton),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .width(250.dp)
                        .height(56.dp)
                ) {
                    Text(
                        text = "Buka Catatan #$id",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun NoteDetailScreen(noteId: Int, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkyBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Detail Catatan",
            style = MaterialTheme.typography.headlineMedium,
            color = PinkyTitle,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "ID: $noteId",
            fontSize = 64.sp,
            fontWeight = FontWeight.Black,
            color = PinkyTextDark
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(containerColor = PinkyButtonMuted),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .width(150.dp)
                .height(48.dp)
        ) {
            Text("Kembali", color = Color.White)
        }
    }
}

@Composable
fun FavoritesScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkyBackground),
        contentAlignment = Alignment.Center
    ) {
        Text("Favorites", color = PinkyTitle)
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkyBackground),
        contentAlignment = Alignment.Center
    ) {
        Text("Profile", color = PinkyTitle)
    }
}
