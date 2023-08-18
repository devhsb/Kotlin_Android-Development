package com.hasib.superheroes.Model

import androidx.annotation.DrawableRes

data class Superhero(
    val title: String,
    val description: String,
   @DrawableRes val image: Int
)