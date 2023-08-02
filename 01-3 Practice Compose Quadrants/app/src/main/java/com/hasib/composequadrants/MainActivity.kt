package com.hasib.composequadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hasib.composequadrants.ui.theme.ComposeQuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantsTheme {
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

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun Quadrants() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            Quadrant(
                modifier = Modifier.weight(1f).background(Color(0xFFEADDFF)),
                header = stringResource(id = R.string.text_composable_text),
                description = stringResource(
                    R.string.text_composable_description,
                )
            )

            Quadrant(
                modifier = Modifier.weight(1f).background(Color(0xFFB69DF8)),
                header = stringResource(R.string.image_composable_text),
                description = stringResource(
                    R.string.image_composable_description
                )
            )
        }

        Row(Modifier.weight(1f)) {
            Quadrant(
                modifier = Modifier.weight(1f).background(Color(0xFFD0BCFF)),
                header = stringResource(R.string.row_composable_text),
                description = stringResource(R.string.row_composable_description),
            )
            Quadrant(
                modifier = Modifier.weight(1f).background(Color(0xFFEADDFF)),
                header = stringResource(R.string.column_composable_text),
                description = stringResource(R.string.column_composable_description),
            )
        }
    }
}

@Composable
fun Quadrant(
    modifier: Modifier = Modifier,
    header: String,
    description: String
    ){
    Column (
        modifier = modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}