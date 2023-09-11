package com.hasib.cupcake.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hasib.cupcake.ui.CupcakeViewModel.CupcakeViewModel
import com.hasib.cupcake.ui.Data.PickupDates

@Composable
fun DateScreen(onCancelButtonClicked: () -> Unit,
               onNextButton: () -> Unit,
               subtotal: Int,
               cupcakeViewModel: CupcakeViewModel
) {
    DateUi(
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButton = onNextButton,
        subtotal = subtotal,
        cupcakeViewModel = cupcakeViewModel
    )
}

@Composable
fun DateUi(
    modifier: Modifier = Modifier,
    onCancelButtonClicked: () -> Unit,
    onNextButton: () -> Unit,
    subtotal: Int,
    cupcakeViewModel: CupcakeViewModel
) {
    FlavorUi(
        appBarTitle = "Choose Pickup Date" ,
        radioButtons = PickupDates().pickupDates,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButton,
        subtotal = subtotal,
        cupcakeViewModel = cupcakeViewModel
    )
}