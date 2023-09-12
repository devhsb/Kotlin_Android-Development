package com.hasib.cupcake.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hasib.cupcake.R

@Composable
fun SummaryScreen(
    onCanelButton: () -> Unit,
    subtotal: Int,
    quantity: String,
    flavor: String,
    pickupDate: String,
    onShareOrder: () -> Unit
    ){
    SummaryUi(
        onCanelButton = onCanelButton,
        subtotal = subtotal,
        quantity = quantity,
        flavor = flavor,
        pickupDate = pickupDate,
        onShareOrder = onShareOrder

    )
}

@Composable
fun SummaryUi(
    modifier: Modifier = Modifier,
    onCanelButton: () -> Unit,
    subtotal: Int,
    quantity: String,
    flavor: String,
    pickupDate: String,
    onShareOrder: () -> Unit
) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        SummaryComponent(orderTitle = "Quantity", orderType = quantity)
        SummaryComponent(orderTitle = "Flavor", orderType = flavor)
        SummaryComponent(orderTitle = "Pickup Date", orderType = pickupDate)

        Text(
            text = stringResource(R.string.subtotal, subtotal),
            modifier = Modifier
                .align(Alignment.End)
                .weight(1f)
                .padding(top = 20.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        SummaryButton(modifier = Modifier.weight(1f), onCanelButton = onCanelButton, onShareOrder = onShareOrder)
    }
}

@Composable
fun SummaryComponent(
    modifier: Modifier = Modifier,
    orderTitle: String,
    orderType: String
) {
    Column {
        Text(
            text = orderTitle,
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = orderType,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 5.dp)
        )
        Divider(
            thickness = 1.dp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
fun SummaryButton(
    modifier: Modifier = Modifier,
    onCanelButton: () -> Unit = {},
    onShareOrder: () -> Unit
) {
    Column {
        Button(
            onClick = onShareOrder,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Send Order to Another App", textAlign = TextAlign.Center)
        }
        OutlinedButton(
            onClick =  onCanelButton ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        ) {
            Text(text = "Cancel", textAlign = TextAlign.Center, color = lightColorScheme().primary)
        }
    }
}



