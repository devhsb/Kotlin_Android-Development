package com.hasib.wellness.model

import androidx.annotation.DrawableRes

data class DailyProgram(
    val day: String,
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)