package com.example.notesappnavigation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DeepPink,
    secondary = SoftPink,
    tertiary = Pink80,
    background = DarkPinkSurface,
    surface = DarkPinkSurface,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = LightPink,
    onSurface = LightPink
)

private val LightColorScheme = lightColorScheme(
    primary = DeepPink,
    secondary = SoftPink,
    tertiary = Pink40,
    background = LightPink,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = DarkPink,
    onSurface = DarkPink
)

@Composable
fun NotesAppNavigationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is disabled to keep the pink theme consistent
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}