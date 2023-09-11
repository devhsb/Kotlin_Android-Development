package com.hasib.cupcake

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hasib.cupcake.ui.Common.CupcakeAppBar
import com.hasib.cupcake.ui.CupcakeViewModel.CupcakeViewModel
import com.hasib.cupcake.ui.DateScreen
import com.hasib.cupcake.ui.FlavorScreen
import com.hasib.cupcake.ui.OrderScreen
import com.hasib.cupcake.ui.SummaryScreen

enum class CupcakeScreens() {
    Start,
    Flavor,
    Pickup,
    Summary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeApp(
    navController: NavHostController = rememberNavController(),
    cupcakeViewModel: CupcakeViewModel = viewModel()
) {
    val cupcakeUiState by cupcakeViewModel.uiState.collectAsState()
    var appBarTitle by rememberSaveable {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            CupcakeAppBar(title = appBarTitle)
        }
    ) { contentPadding ->

        NavHost(
            navController = navController,
            startDestination = CupcakeScreens.Start.name,
            modifier = Modifier.padding(contentPadding)
        ) {
            composable(
                route = CupcakeScreens.Start.name
            ) {
                appBarTitle = "Cupcake"
                OrderScreen(
                    oneCupcakeBtn = {
                        navController.navigate(CupcakeScreens.Flavor.name)
                        cupcakeViewModel.updateUi(2, quantity = "2 Cupcake")
                    },
                    sixCupcakeBtn = {
                        navController.navigate(CupcakeScreens.Flavor.name)
                        cupcakeViewModel.updateUi(12, quantity = "6 Cupcakes")
                    },
                    twelveCupcakeBtn = {
                        navController.navigate(CupcakeScreens.Flavor.name)
                        cupcakeViewModel.updateUi(24, quantity = "12 Cupcakes")
                    },
                )
            }

            composable(route = CupcakeScreens.Flavor.name) {
                appBarTitle = "Choose Flavor"
                FlavorScreen(
                    onNextButtonClicked = {
                        navController.navigate(CupcakeScreens.Pickup.name)
                    },
                    onCancelButtonClicked ={
                        cupcakeViewModel.resetUi()
                        navController.popBackStack(
                            route = CupcakeScreens.Start.name,
                            inclusive = false
                        )
                    },
                    subtotal = cupcakeUiState.subtotal,
                    cupcakeViewModel = cupcakeViewModel
                )
            }

            composable(route = CupcakeScreens.Pickup.name) {
                appBarTitle = "Choose Pickup Date"
                DateScreen(
                    onCancelButtonClicked = {
                        cupcakeViewModel.resetUi()
                        navController.popBackStack(
                            route = CupcakeScreens.Start.name,
                            inclusive = false
                        )
                    },

                    onNextButton = {
                        navController.navigate(CupcakeScreens.Summary.name)
                    },
                    subtotal = cupcakeUiState.subtotal,
                    cupcakeViewModel = cupcakeViewModel
                )
            }

            composable(
                route = CupcakeScreens.Summary.name,
            ) {
                appBarTitle = "Order Summary"
                SummaryScreen(
                    onCanelButton = {
                        cupcakeViewModel.resetUi()
                        navController.popBackStack(
                        route = CupcakeScreens.Start.name,
                        inclusive = false
                    )
                    },
                    subtotal = cupcakeUiState.subtotal,
                    quantity = cupcakeUiState.quantity,
                    flavor = cupcakeUiState.flavor,
                    pickupDate = cupcakeUiState.pickupDate
                )
            }
        }
    }
}