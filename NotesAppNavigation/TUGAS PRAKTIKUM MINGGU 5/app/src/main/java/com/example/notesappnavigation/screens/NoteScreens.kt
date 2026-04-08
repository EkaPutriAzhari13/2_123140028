package com.example.notesappnavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesappnavigation.model.Note
import com.example.notesappnavigation.ui.theme.*

@Composable
fun NoteListScreen(notes: List<Note>, onNoteClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Catatan Pinky",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = PinkPrimary
        )
        Text(
            "Daftar Catatan Hari Ini",
            fontSize = 18.sp,
            color = GraySubtitle,
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(notes) { note ->
                Button(
                    onClick = { onNoteClick(note.id) },
                    colors = ButtonDefaults.buttonColors(containerColor = PinkPrimary),
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(55.dp)
                ) {
                    Text("Buka Catatan #${note.id}", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}

@Composable
fun NoteDetailScreen(
    note: Note, 
    isFavorite: Boolean,
    onFavClick: () -> Unit,
    onEditClick: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Detail Catatan",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = PinkPrimary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "ID: ${note.id}",
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            color = PinkDark
        )
        Spacer(modifier = Modifier.height(32.dp))
        
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = onBack,
                colors = ButtonDefaults.buttonColors(containerColor = BrownishPink),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .width(120.dp)
                    .height(50.dp)
            ) {
                Text("Kembali", color = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = onFavClick) {
                Icon(
                    Icons.Default.Favorite, 
                    contentDescription = null, 
                    tint = if (isFavorite) Color.Red else Color.Gray
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onEditClick) {
            Text("Edit Catatan Ini")
        }
    }
}

@Composable
fun FavoritesScreen(notes: List<Note>, favoriteIds: List<Int>, onNoteClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkBackground)
    ) {
        Text(
            "Favorite Notes", 
            style = MaterialTheme.typography.headlineMedium, 
            fontWeight = FontWeight.ExtraBold, 
            modifier = Modifier.padding(16.dp), 
            color = PinkPrimary
        )
        
        val favoriteNotes = notes.filter { favoriteIds.contains(it.id) }
        
        if (favoriteNotes.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Belum ada favorit.", color = Color.Gray)
            }
        } else {
            LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(favoriteNotes) { note ->
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onNoteClick(note.id) },
                        color = Color.White.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Favorite, contentDescription = null, tint = Color.Red)
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(note.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkBackground)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = PinkPrimary,
            modifier = Modifier.align(Alignment.Start).padding(bottom = 32.dp)
        )

        Box(contentAlignment = Alignment.BottomEnd) {
            Surface(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(4.dp, PinkPrimary, CircleShape),
                color = PinkPrimary.copy(alpha = 0.1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.padding(30.dp),
                    tint = PinkPrimary
                )
            }
            SmallFloatingActionButton(
                onClick = { },
                containerColor = PinkPrimary,
                contentColor = Color.White,
                shape = CircleShape,
                modifier = Modifier.offset(x = (-8).dp, y = (-8).dp)
            ) {
                Icon(Icons.Default.Edit, contentDescription = "Edit Profile Picture", modifier = Modifier.size(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.elevatedCardColors(containerColor = Color.White.copy(alpha = 0.7f)),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Eka Putri Azhari Ritonga", 
                    style = MaterialTheme.typography.headlineSmall, 
                    fontWeight = FontWeight.Bold,
                    color = PinkDark
                )
                Text(
                    text = "Student", 
                    style = MaterialTheme.typography.bodyMedium, 
                    color = PinkPrimary
                )
                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), thickness = 1.dp, color = PinkPrimary.copy(alpha = 0.2f))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Info, contentDescription = null, modifier = Modifier.size(18.dp), tint = PinkPrimary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "NIM: 123140028", style = MaterialTheme.typography.titleMedium, color = PinkDark)
                }
            }
        }
    }
}

@Composable
fun AddNoteScreen(onSave: (String, String, String, String) -> Unit, onBack: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var reminder by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkBackground)
            .padding(16.dp)
    ) {
        Text("Tambah Catatan Baru", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = PinkPrimary)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Judul") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("Deskripsi") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = reminder, onValueChange = { reminder = it }, label = { Text("Reminder") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = content, onValueChange = { content = it }, label = { Text("Isi") }, modifier = Modifier.fillMaxWidth().weight(1f))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = onBack, modifier = Modifier.weight(1f)) { Text("Batal") }
            Button(onClick = { onSave(title, description, content, reminder) }, modifier = Modifier.weight(1f)) { Text("Simpan") }
        }
    }
}

@Composable
fun EditNoteScreen(note: Note, onSave: (String, String, String, String) -> Unit, onBack: () -> Unit) {
    var title by remember { mutableStateOf(note.title) }
    var description by remember { mutableStateOf(note.description) }
    var content by remember { mutableStateOf(note.content) }
    var reminder by remember { mutableStateOf(note.reminder) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkBackground)
            .padding(16.dp)
    ) {
        Text("Edit Catatan", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = PinkPrimary)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Judul") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("Deskripsi") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = reminder, onValueChange = { reminder = it }, label = { Text("Reminder") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = content, onValueChange = { content = it }, label = { Text("Isi") }, modifier = Modifier.fillMaxWidth().weight(1f))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = onBack, modifier = Modifier.weight(1f)) { Text("Batal") }
            Button(onClick = { onSave(title, description, content, reminder) }, modifier = Modifier.weight(1f)) { Text("Simpan") }
        }
    }
}
