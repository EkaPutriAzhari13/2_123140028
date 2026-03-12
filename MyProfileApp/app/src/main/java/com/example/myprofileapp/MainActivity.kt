package com.example.myprofileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.background
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                MyProfileApp()
            }
        }
    }
}

@Composable
fun MyProfileApp() {

    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    val primaryColor = Color(0xFF673AB7) // Deep Purple
    val backgroundColor = Color(0xFFF3E5F5) // Light Purple Background

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(tween(800)) + slideInVertically(
                initialOffsetY = { -200 }
            )
        ) {
            ProfileHeader(name = "Eka Putri Azhari Ritonga", accentColor = primaryColor)
        }

        Spacer(modifier = Modifier.height(20.dp))

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(tween(1000)) + slideInVertically(
                initialOffsetY = { 200 }
            )
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Seorang mahasiswa yang tertarik dalam pengembangan aplikasi mobile dan desain UI/UX.",
                    textAlign = TextAlign.Center,
                    color = Color.DarkGray,
                    fontStyle = FontStyle.Italic,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(30.dp))

                ProfileCard(accentColor = primaryColor)

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                ) {
                    Text("Edit Profile", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun ProfileHeader(name: String, accentColor: Color) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {

            // Background Circle with a slight variation
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(accentColor.copy(alpha = 0.1f))
            )

            // Profile Image
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
                    .border(3.dp, accentColor, CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF311B92)
        )
    }
}

@Composable
fun ProfileCard(accentColor: Color) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            InfoItem(
                icon = Icons.Default.Email,
                label = "Email Address",
                value = "eka.123140028@student.itera.ac.id",
                accentColor = accentColor
            )

            InfoItem(
                icon = Icons.Default.Phone,
                label = "Phone Number",
                value = "085187081046",
                accentColor = accentColor
            )

            InfoItem(
                icon = Icons.Default.LocationOn,
                label = "Current Location",
                value = "Lampung, Indonesia",
                accentColor = accentColor
            )
        }
    }
}

@Composable
fun InfoItem(
    icon: ImageVector,
    label: String,
    value: String,
    accentColor: Color
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(accentColor.copy(alpha = 0.1f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = accentColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {

            Text(
                text = label,
                fontSize = 11.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
    }
}
