package com.hasib.woof.model

import androidx.annotation.DrawableRes

data class Dog(
    val dogName: String,
    val dogAge: Int,
    @DrawableRes val dogImage: Int
) {

}