package com.hasib.dessertclicker.ui

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hasib.dessertclicker.R
import com.hasib.dessertclicker.ui.DessertViewModel.DessertUiState
import com.hasib.dessertclicker.ui.DessertViewModel.DessertViewModel

//@Preview(showSystemUi = true)
@Composable
fun DessertScreen(){
    Column {
        DessertLayout()
    }
}

@Composable
fun DessertLayout(
    modifier: Modifier = Modifier,
    dessertViewModel: DessertViewModel = viewModel()
) {
    val dessertUiState by dessertViewModel.uiState.collectAsState()
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bakery_back),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = dessertUiState.imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.Center)
                        .clickable {
                            dessertViewModel.addDessert()
                        },
                    contentScale = ContentScale.Crop
                )
            }
            DessertRevenue(
                soldedItem = dessertUiState.solded,
                totalRevenue = dessertUiState.revenue
            )
        }

    }
}

@Composable
fun DessertRevenue(
    modifier: Modifier = Modifier,
    soldedItem: Int,
    totalRevenue: Int
){
    Column(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(15.dp),
        ) {
            Text(
                text = "Deserts Sold",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = stringResource(id = R.string.solded_items, soldedItem),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
            )
        }
        Row(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp),

        ) {
            Text(
                text = "Total Revenue",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = stringResource(id = R.string.total_revenue, totalRevenue),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
            )
        }
    }
}






















