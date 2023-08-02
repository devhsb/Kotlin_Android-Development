package com.hasib.hey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            text = "HaSeeb",
            lineHeight = 70.sp,
            fontSize = 70.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = "Software Developer",
            modifier = Modifier
                .padding(20.dp)
                .align(alignment = Alignment.End)
        )
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Preview My Name"
)
@Composable
fun MyNamePreview(){
    HeyTheme {
        MyName()
    }
}