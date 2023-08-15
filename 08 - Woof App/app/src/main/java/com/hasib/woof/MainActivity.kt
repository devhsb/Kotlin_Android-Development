package com.hasib.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hasib.woof.data.Dogs
import com.hasib.woof.model.Dog
import com.hasib.woof.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun WoofApp() {
    
}

@Composable
fun DogsList(dogs: List<Dog>) {
    LazyColumn {
        items(dogs) { dog ->
                DogCard(
                    dog = dog,
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.largePadding),
                        start = dimensionResource(id = R.dimen.MediumPadding),
                        end = dimensionResource(id = R.dimen.MediumPadding))
                )
        }
    }
}

@Composable
fun DogCard(modifier: Modifier = Modifier,
            dog: Dog
) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
          Image(
              painter = painterResource(id = dog.dogImage),
              contentDescription = null,
              modifier = Modifier
                  .size(90.dp)
                  .padding(dimensionResource(id = R.dimen.MediumPadding))
                  .clip(shape = RoundedCornerShape(50)),
              contentScale = ContentScale.Crop
          )
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.MediumPadding))
            ) {
                Text(
                    text = dog.dogName,
                    style = MaterialTheme.typography.headlineMedium)
                Text(
                    text = "${dog.dogAge} years old",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}


@Composable
fun CardPreview() {
    DogCard(dog = Dogs().getDogsList().get(2))
}

@Preview()
@Composable
fun ListPreview() {
    DogsList(dogs = Dogs().getDogsList())
}









