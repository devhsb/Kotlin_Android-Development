package com.hasib.cupcake.ui.CupcakeViewModel

data class CupcakeUiState(
    var subtotal: Int = 0,
    var quantity: String = "",
    var flavor: String = "",
    var pickupDate: String = ""
)