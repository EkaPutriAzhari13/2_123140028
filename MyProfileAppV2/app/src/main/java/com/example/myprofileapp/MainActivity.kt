package com.example.myprofileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myprofileapp.viewmodel.ProfileViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProfileApp()
        }
    }
}

@Composable
fun MyProfileApp(viewModel: ProfileViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    // KONSEP WARNA: AURORA NIGHT (Modern & Elegant)
    val mainGradient = if (uiState.isDarkMode) {
        Brush.verticalGradient(listOf(Color(0xFF0F2027), Color(0xFF203A43), Color(0xFF2C5364)))
    } else {
        Brush.linearGradient(listOf(Color(0xFFE0EAFC), Color(0xFFCFDEF3)))
    }

    val accentColor = Color(0xFF6C5CE7)
    val cardColor = if (uiState.isDarkMode) Color.White.copy(alpha = 0.1f) else Color.White.copy(alpha = 0.7f)
    val textColor = if (uiState.isDarkMode) Color.White else Color(0xFF2D3436)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mainGradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // --- BAGIAN ATAS: Header & Switch ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "My Profile",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = textColor
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Ikon diganti ke Settings karena WbSunny/Brightness2 sering tidak terdeteksi
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = null,
                        tint = textColor,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Switch(
                        checked = uiState.isDarkMode,
                        onCheckedChange = { viewModel.toggleDarkMode(it) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // --- FOTO PROFIL: MODERN SQUIRCLE ---
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(Color.White.copy(alpha = 0.3f))
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.loopy),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(32.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(uiState.name, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = textColor)

            Spacer(modifier = Modifier.height(8.dp))

            // Progress Bar Kelengkapan Profil
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                LinearProgressIndicator(
                    progress = { uiState.completeness },
                    modifier = Modifier
                        .width(150.dp)
                        .height(8.dp)
                        .clip(CircleShape),
                    color = accentColor,
                    trackColor = accentColor.copy(alpha = 0.2f)
                )
                Text(
                    "Profile Strength: ${(uiState.completeness * 100).toInt()}%",
                    fontSize = 12.sp,
                    color = textColor.copy(alpha = 0.6f),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            AnimatedContent(targetState = uiState.isEditMode, label = "edit_anim") { isEditing ->
                if (isEditing) {
                    EditProfileForm(uiState, viewModel, textColor, accentColor)
                } else {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = uiState.bio,
                            textAlign = TextAlign.Center,
                            color = textColor.copy(alpha = 0.8f),
                            lineHeight = 22.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        InfoTile(Icons.Default.Email, uiState.email, cardColor, textColor)
                        InfoTile(Icons.Default.Phone, uiState.phone, cardColor, textColor)
                        InfoTile(Icons.Default.LocationOn, uiState.location, cardColor, textColor)

                        Spacer(modifier = Modifier.height(40.dp))

                        Button(
                            onClick = { viewModel.toggleEditMode() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = accentColor)
                        ) {
                            Icon(Icons.Default.Edit, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(8.dp))
                            Text("Modify Profile", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun InfoTile(icon: androidx.compose.ui.graphics.vector.ImageVector, value: String, bgColor: Color, textColor: Color) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        color = bgColor,
        shape = RoundedCornerShape(18.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.2f))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = textColor.copy(alpha = 0.6f), modifier = Modifier.size(20.dp))
            Spacer(Modifier.width(16.dp))
            Text(value, color = textColor, fontWeight = FontWeight.Medium, fontSize = 15.sp)
        }
    }
}

@Composable
fun EditProfileForm(
    uiState: com.example.myprofileapp.data.ProfileUiState,
    viewModel: ProfileViewModel,
    textColor: Color,
    accentColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f)),
        shape = RoundedCornerShape(28.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text("Update Your Info", fontWeight = FontWeight.ExtraBold, color = Color.Black, fontSize = 20.sp)

            CustomTextField(uiState.editName, "Name", Icons.Default.Person) { viewModel.updateEditName(it) }
            CustomTextField(uiState.editBio, "Bio", Icons.Default.Info) { viewModel.updateEditBio(it) }
            CustomTextField(uiState.editEmail, "Email", Icons.Default.Email) { viewModel.updateEditEmail(it) }
            CustomTextField(uiState.editPhone, "Phone", Icons.Default.Phone) { viewModel.updateEditPhone(it) }
            // Ikon Map diganti ke Place karena Map sering tidak terdeteksi
            CustomTextField(uiState.editLocation, "Location", Icons.Default.Place) { viewModel.updateEditLocation(it) }

            Spacer(Modifier.height(8.dp))

            Button(
                onClick = { viewModel.saveProfile() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = accentColor)
            ) {
                Text("Save Changes", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun CustomTextField(value: String, label: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = null, modifier = Modifier.size(18.dp)) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        singleLine = true
    )
}