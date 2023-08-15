package com.hasib.woof

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    WoofApp()
                }
            }
        }
    }
}

@Composable
fun WoofApp() {
    DogsList(dogs = Dogs().getDogsList())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogsList(dogs: List<Dog>) {

    Scaffold(
        topBar = {
            WoofTopAppbar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(dogs) { dog ->
                DogCard(
                    dog = dog,
                    modifier = Modifier.padding(
                        top = dimensionResource(id = R.dimen.largePadding),
                        start = dimensionResource(id = R.dimen.MediumPadding),
                        end = dimensionResource(id = R.dimen.MediumPadding)
                    )
                )
            }
        }
    }
}

@Composable
fun DogCard(modifier: Modifier = Modifier,
            dog: Dog
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp)
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
                    style = MaterialTheme.typography.displayLarge,
                    letterSpacing = 2.sp
                )
                Text(
                    text = "${dog.dogAge} years old",
                    style = MaterialTheme.typography.labelLarge,
                    letterSpacing = 1.sp
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppbar(modifier: Modifier = Modifier) {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.displayMedium,
                        fontSize = 40.sp
                    )
                }
            )
}


//@Preview()
@Composable
fun CardPreview() {
    DogCard(dog = Dogs().getDogsList().get(2))
}

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ListPreview() {
    WoofTheme(useDarkTheme = true) {
        DogsList(dogs = Dogs().getDogsList())
    }
}









