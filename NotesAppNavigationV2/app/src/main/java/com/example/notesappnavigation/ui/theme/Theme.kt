package com.example.notesappnavigation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Pink80,
    onPrimary = PinkDark,
    primaryContainer = PinkDark,
    onPrimaryContainer = Pink80,
    secondary = PurpleGrey80,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
    surfaceVariant = Color(0xFF333333)
)

private val LightColorScheme = lightColorScheme(
    primary = PinkPrimary,
    onPrimary = White,
    primaryContainer = PinkLight,
    onPrimaryContainer = PinkDark,
    secondary = PinkPrimary,
    onSecondary = White,
    background = Color(0xFFF5F0FF),
    surface = White,
    onSurface = PinkDark,
    surfaceVariant = PinkLight
)

@Composable
fun NotesAppNavigationTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
