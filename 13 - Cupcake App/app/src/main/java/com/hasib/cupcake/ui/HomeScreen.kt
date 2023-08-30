package com.hasib.cupcake.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hasib.cupcake.R
import org.w3c.dom.Text

@Composable
fun CupcakeApp() {
    OrderScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CupcakeAppBar()
        }
    ) { contentPadding ->

        Column(
            modifier = Modifier.padding(contentPadding).fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //cupcake image
            Image(
                painter = painterResource(id = R.drawable.cupcake),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier.size(170.dp).padding(top = 30.dp)
            )

            // order text
            Text(
                text = stringResource(R.string.order_cupcakes),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 40.dp)
            )

            // order buttons
            OrderButton(text = "One Cupcake")
            OrderButton(text = "Six Cupcakes")
            OrderButton(text = "Twelve Cupcakes")

        }
    }
}

@Composable
fun OrderButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width(250.dp)
            .padding(top = 20.dp)
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar(){
    TopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            color = MaterialTheme.colorScheme.onPrimary
        )
    },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            MaterialTheme.colorScheme.primary
        )
    )
}