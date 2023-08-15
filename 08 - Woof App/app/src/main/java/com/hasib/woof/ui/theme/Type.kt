package com.hasib.woof.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hasib.woof.R

// Set of Material typography styles to start with
val Vampire_wars = FontFamily(
    Font(R.font.azonix)
)
val Azonix = FontFamily(
    Font(R.font.vampire_wars, FontWeight.Bold)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Vampire_wars,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    displayMedium = TextStyle(
        fontFamily = Azonix,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)