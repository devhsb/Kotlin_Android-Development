package com.hasib.lunchtray

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hasib.lunchtray.ui.screens.LunchTray

enum class Screens {
    Start
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayScreens() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            })
        }
    ) {contentPadding ->

        val navController: NavHostController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screens.Start.name,
            modifier = Modifier.padding(contentPadding)
        ) {

            composable(
                route = Screens.Start.name
            ) {
                LunchTray()
            }
        }

    }
}