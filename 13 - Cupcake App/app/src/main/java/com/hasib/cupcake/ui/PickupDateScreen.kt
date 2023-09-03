package com.hasib.cupcake.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hasib.cupcake.ui.Data.PickupDates

@Composable
fun DateScreen() {
    DateUi()
}

@Composable
fun DateUi(
    modifier: Modifier = Modifier
) {
    FlavorUi(
        appBarTitle = "Choose Pickup Date" ,
        radioButtons = PickupDates().pickupDates
    )
}