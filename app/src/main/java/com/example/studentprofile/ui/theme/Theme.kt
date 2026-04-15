package com.example.studentprofile.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Cyan400,
    onPrimary = Navy900,
    secondary = Cyan300,
    onSecondary = Navy900,
    background = Navy900,
    onBackground = White,
    surface = Navy800,
    onSurface = White,
    surfaceVariant = Navy700,
    onSurfaceVariant = Gray300,
    secondaryContainer = Navy700,
    onSecondaryContainer = Cyan300,
    outline = Navy600
)

@Composable
fun StudentProfileTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}