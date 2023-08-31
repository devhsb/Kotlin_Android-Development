package com.hasib.cupcake.ui.Common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hasib.cupcake.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar(title: String){
    TopAppBar(title = {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onPrimary
        )
    },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            MaterialTheme.colorScheme.primary
        )
    )
}