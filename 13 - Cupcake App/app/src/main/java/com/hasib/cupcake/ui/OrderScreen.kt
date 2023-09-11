package com.hasib.cupcake.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hasib.cupcake.CupcakeScreens
import com.hasib.cupcake.R
import com.hasib.cupcake.ui.Common.CupcakeAppBar
import com.hasib.cupcake.ui.CupcakeViewModel.CupcakeViewModel


@Composable
fun OrderScreen(
    oneCupcakeBtn: () -> Unit,
    sixCupcakeBtn: () -> Unit,
    twelveCupcakeBtn: () -> Unit,
) {
    OrderUi(
        oneCupcakeBtn = oneCupcakeBtn,
        sixCupcakeBtn = sixCupcakeBtn,
        twelveCupcakeBtn = twelveCupcakeBtn
    )
}

@Composable
fun OrderUi(
    modifier: Modifier = Modifier,
    cupcakeViewModel: CupcakeViewModel = viewModel(),
    oneCupcakeBtn: () -> Unit,
    sixCupcakeBtn: () -> Unit,
    twelveCupcakeBtn: () -> Unit

) {
    val cupcakeUiState by cupcakeViewModel.uiState.collectAsState()
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //cupcake image
            Image(
                painter = painterResource(id = R.drawable.cupcake),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .size(170.dp)
                    .padding(top = 30.dp)
            )

            // order text
            Text(
                text = stringResource(R.string.order_cupcakes),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 40.dp)
            )

            // order buttons
            OrderButton(text = "One Cupcake", onClick = oneCupcakeBtn)
            OrderButton(text = "Six Cupcakes", onClick = sixCupcakeBtn)
            OrderButton(text = "Twelve Cupcakes", onClick = twelveCupcakeBtn)

        }
}

@Composable
fun OrderButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(250.dp)
            .padding(top = 20.dp)
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
    }
}

