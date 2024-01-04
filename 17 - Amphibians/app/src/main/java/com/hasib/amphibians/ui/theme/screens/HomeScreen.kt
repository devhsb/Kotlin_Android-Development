package com.hasib.amphibians.ui.theme.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.hasib.amphibians.R
import com.hasib.amphibians.data.AmphibianModel

@Composable
fun HomeScreen(modifier: Modifier) {
    HomeScreenComponents(
        modifier = modifier
    )
}

@Composable
fun HomeScreenComponents(
    modifier: Modifier = Modifier
) {
    val amUiState: AmphibianViewModel = viewModel(factory = AmphibianViewModel.Factory)
    AmphibianVerticalList(amphibiansList = amUiState.amphibianUiState.value, modifier = modifier)
}

@Composable
fun AmphibianCard(
    modifier: Modifier = Modifier,
    amphibianName: String,
    type: String,
    description: String,
    image: String,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column {
            Text(
                modifier = Modifier.padding(10.dp),
                text = amphibianName + "($type)",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            AsyncImage(
                model = image,
                contentDescription = stringResource(R.string.text_pic),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )


            Text(
                text = description, modifier = Modifier.padding(10.dp)
            )
        }


    }
}


@Composable
fun AmphibianVerticalList(
    modifier: Modifier = Modifier,
    amphibiansList: List<AmphibianModel>
) {
    if(amphibiansList.size > 0){
        LazyColumn(
            modifier = modifier
        ) {
            items(amphibiansList.size) {amphibian ->
                val currentAmphibian = amphibiansList[amphibian]
                AmphibianCard(
                    amphibianName = currentAmphibian.name,
                    type = currentAmphibian.type,
                    description = currentAmphibian.description,
                    image = currentAmphibian.imgSrc
                )
            }
        }
    }else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "No item found")
        }
    }

}














