package com.orangecash.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = OrangeMain,
    primaryContainer = OrangeMain,
    secondary = OrangeDark,
    background = White,
    surface = White,
    onPrimary = White,
    onSecondary = White,
    onBackground = DarkGray,
    onSurface = DarkGray,
)

@Composable
fun OrangeCashTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = OrangeCashTypography,
        content = content
    )
}
