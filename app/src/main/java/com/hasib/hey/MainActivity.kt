package com.hasib.hey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasib.hey.ui.theme.HeyTheme
import androidx.compose.ui.tooling.preview.Preview as Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyName()
                }
            }
        }
    }
}

@Composable
fun MyName(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Text(
            text = stringResource(R.string.my_name),
            lineHeight = 40.sp,
            fontSize = 70.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(R.string.my_field),
            modifier = Modifier
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@Preview(
    showSystemUi = true,
    name = "Show result"
)
@Composable
fun BackgroundImage(modifier: Modifier = Modifier) {
    Box(modifier) {
        Image(
            painter = painterResource(id = R.drawable.wallpaper_back),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.7F
        )
        MyName(
            modifier = Modifier.fillMaxSize()
        )
    }
}