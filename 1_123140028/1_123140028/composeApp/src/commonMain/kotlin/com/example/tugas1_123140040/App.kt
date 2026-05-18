package com.example.tugas1_123140040

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import tugas1_123140028.composeapp.generated.resources.Res
import tugas1_123140028.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {
        // Pakai Column supaya teksnya berurutan ke bawah
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Halo, Eka Putri Azhari Ritonga!") // Ganti dengan nama asli
            Text("NIM: 123140028")   // Ganti dengan NIM asli

            // Ini untuk nampilin nama platform (Android/Desktop)
            val platformName = getPlatform().name
            Text("Platform: $platformName")
        }
    }
}