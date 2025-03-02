package com.example.mycityapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mycityapp.R

val instrumentSans = FontFamily(
    Font(R.font.instrument_sans)
)

val inter = FontFamily(
    Font(R.font.inter_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = instrumentSans,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        letterSpacing = 5.sp,
        brush = Brush.linearGradient(
            colors = listOf(Color(0xFFFF0000), Color(0xFF0000FF))
        )
    ),
    bodyMedium = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 2.sp
    ),
    labelLarge = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        letterSpacing = 4.sp,
        brush = Brush.linearGradient(
            colors = listOf(Color(0xFFFF0000), Color(0xFF0000FF))
        )
    ),
    labelMedium = TextStyle(
        fontFamily = inter,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 2.sp
    ),
    labelSmall = TextStyle(
        fontFamily = inter,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 2.sp
    ),
    titleMedium = TextStyle(
        fontFamily = inter,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 3.sp,
        lineHeight = 32.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)