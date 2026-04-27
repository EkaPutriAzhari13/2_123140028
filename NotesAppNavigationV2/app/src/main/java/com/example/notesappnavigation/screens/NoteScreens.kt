package com.example.notesappnavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesappnavigation.model.Note
import com.example.notesappnavigation.ui.NoteViewModel
import com.example.notesappnavigation.ui.NotesUiState
import com.example.notesappnavigation.data.SortOrder
import java.util.Locale

@Composable
fun NoteListScreen(
    uiState: NotesUiState,
    onNoteClick: (Long) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Catatan Pinky",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            ),
            color = MaterialTheme.colorScheme.primary
        )
        
        Text(
            text = "Daftar Catatan Hari Ini",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )

        when (uiState) {
            is NotesUiState.Loading -> CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            is NotesUiState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(uiState.notes) { note ->
                        Button(
                            onClick = { onNoteClick(note.id) },
                            modifier = Modifier.fillMaxWidth().height(56.dp),
                            shape = RoundedCornerShape(28.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text(
                                "Buka Catatan #${note.id}",
                                color = Color.White,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }
            else -> {
                Text("Belum ada catatan", color = MaterialTheme.colorScheme.outline)
            }
        }
    }
}

@Composable
fun NoteDetailScreen(
    note: Note,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Detail Catatan",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "ID: ${note.id}",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.ExtraBold),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.wrapContentWidth().height(48.dp).padding(horizontal = 32.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF884D5E) // Matching the dark brownish-pink in image
            )
        ) {
            Text("Kembali", color = Color.White)
        }
    }
}

@Composable
fun ProfileScreen(viewModel: NoteViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun FavoritesScreen(favoriteNotes: List<Note>, onNoteClick: (Long) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        if (favoriteNotes.isEmpty()) {
            Text("No Favorites", color = MaterialTheme.colorScheme.primary)
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(favoriteNotes) { note ->
                    Button(
                        onClick = { onNoteClick(note.id) },
                        modifier = Modifier.fillMaxWidth().height(56.dp),
                        shape = RoundedCornerShape(28.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text("Favorite #${note.id}", color = Color.White)
                    }
                }
            }
        }
    }
}

// Keeping original Add/Edit screens but simplified if needed, 
// though image didn't show them. I'll keep them functional but themed.

@Composable
fun AddNoteScreen(onSave: (String, String, String, String) -> Unit, onBack: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Add New Note", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(24.dp))
        
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") },
            modifier = Modifier.fillMaxWidth().height(150.dp),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onSave(title, "", content, "") },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text("Save Note")
        }
        
        TextButton(onClick = onBack) {
            Text("Cancel", color = MaterialTheme.colorScheme.outline)
        }
    }
}

@Composable
fun EditNoteScreen(note: Note, onSave: (Note) -> Unit, onBack: () -> Unit) {
    var title by remember { mutableStateOf(note.title) }
    var content by remember { mutableStateOf(note.content) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Edit Note", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(24.dp))
        
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") },
            modifier = Modifier.fillMaxWidth().height(150.dp),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onSave(note.copy(title = title, content = content)) },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text("Update Note")
        }
        
        TextButton(onClick = onBack) {
            Text("Cancel", color = MaterialTheme.colorScheme.outline)
        }
    }
}
