package pl.pw.laa.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pl.pw.laa.common.R

val Lateef = FontFamily(
    Font(R.font.lateef_bold, FontWeight.Bold),
    Font(R.font.lateef_extrabold, FontWeight.ExtraBold),
    Font(R.font.lateef_extralight, FontWeight.ExtraLight),
    Font(R.font.lateef_light, FontWeight.Light),
    Font(R.font.lateef_medium, FontWeight.Medium),
    Font(R.font.lateef_regular, FontWeight.Normal),
    Font(R.font.lateef_semibold, FontWeight.SemiBold),
)

// Set of Material typography styles to start with

val Typography = Typography(
    // menu button
    titleMedium = TextStyle(
        fontFamily = Lateef,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 42.sp,
        // letterSpacing = 0.2.sp,
    ),
    displayLarge = TextStyle(
        fontFamily = Lateef,
        fontWeight = FontWeight.Normal,
        fontSize = 42.sp,
        lineHeight = 56.sp,
        // letterSpacing = 0.2.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = Lateef,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
        lineHeight = 12.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = Lateef,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 36.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = Lateef,
        fontWeight = FontWeight.Light,
        fontSize = 56.sp,
        lineHeight = 72.sp,
        letterSpacing = 0.5.sp,
    ),
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
