package com.hasib.quotes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Quote(
    @DrawableRes val imageId: Int,
    @StringRes val textId: Int
)
