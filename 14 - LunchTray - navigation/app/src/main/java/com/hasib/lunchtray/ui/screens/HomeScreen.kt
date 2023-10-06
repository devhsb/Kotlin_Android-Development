package com.hasib.lunchtray.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hasib.lunchtray.R

@Composable
fun LunchTray() {
    LunchTrayUi()
}

@Composable
fun LunchTrayUi() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(250.dp)
        ) {
            Text(text = stringResource(R.string.order_now_text))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LunchTrayPreview() {
    LunchTrayUi()
}