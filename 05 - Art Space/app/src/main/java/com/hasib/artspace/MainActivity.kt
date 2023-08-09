package com.hasib.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hasib.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var imageId by remember {
        mutableStateOf(1)
    }
    var title = ""
    var imageDate = ""

    var imageRes = R.drawable.art1

    when(imageId) {
        1 -> {
            imageRes = R.drawable.art1
            title = "Art 1"
            imageDate = "1/5/2020"
        }
        2 -> {
            imageRes = R.drawable.art2
            title = "Art 2"
            imageDate = "6/4/2021"
        }
        3 -> {
            imageRes = R.drawable.art3
            title = "Art 3"
            imageDate = "12/7/2022"
        }
        4 -> {
            imageRes = R.drawable.art4
            title = "Art 4"
            imageDate = "26/1/2023"
        }
        else -> R.drawable.art1
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ArtImage(imageRes = imageRes)
        ArtDescription(imageTitle = title, publishedDate = imageDate)

//        NextPrev Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp)
        ){
            ArtButton(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 20.dp),
                onClick = {
                          imageId--
                    if(imageId < 1) {
                        imageId = 4
                    }
                },
                text = "Preview"
            )

            ArtButton(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp),
                onClick = {
                          imageId++
                    if(imageId > 4) {
                        imageId = 1
                    }
                },
                text = "Next"
            )
        }


    }
}


//Art Image
@Composable
fun ArtImage(
    modifier: Modifier = Modifier,
    @DrawableRes imageRes: Int
) {
    Box(
        modifier = Modifier.shadow(elevation = 3.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .padding(50.dp)
                .width(200.dp)
                .height(250.dp)
        )
    }
}

//Art Description
@Composable
fun ArtDescription(modifier: Modifier = Modifier, imageTitle: String, publishedDate: String) {
    Column(
        modifier = Modifier
            .padding(top = 70.dp)
            .background(Color(220, 220, 220))
            .width(300.dp)
    ) {
        Text(
            text = imageTitle,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(20.dp, 5.dp, 30.dp, 5.dp)
        )
        Text(
            text = publishedDate,
            modifier = Modifier.padding(20.dp, 0.dp, 30.dp, 5.dp)
        )
    }
}

//Next Prev Button
@Composable
fun ArtButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = text)
    }
}













