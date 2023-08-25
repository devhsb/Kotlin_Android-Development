package com.hasib.unscamble.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hasib.unscamble.R

@Composable
fun GameScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(dimensionResource(id = R.dimen.large_dimen)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.medium_dimen)),
            style = MaterialTheme.typography.headlineMedium
        )
        GameIO()
        Buttons()

        Card(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.large_dimen))
        ) {
            Text(text = "Score: 0", style = MaterialTheme.typography.displaySmall)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameIO(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.medium_dimen)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Score Card
            Card(
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            ) {
                Text(
                    modifier = Modifier.padding(
                        vertical = dimensionResource(id = R.dimen.small_dimen),
                        horizontal = dimensionResource(id = R.dimen.medium_dimen)
                    ),
                    text = "0/10"
                )
            }
            // Output Text
            Text(
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.medium_dimen)),
                text = "Guess me",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "Unscramble the word using all the letters",
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.medium_dimen))
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(vertical = dimensionResource(id = R.dimen.medium_dimen))
                    .background(Color.White),
                value = "",
                onValueChange = {},
                label = {
                    Text(text = "Enter your word")
                },
                shape = MaterialTheme.shapes.large
            )
        }
    }
}

@Composable
fun Buttons() {
    Column(
        modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.medium_dimen))
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit", textAlign = TextAlign.Center)
        }

        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(id = R.dimen.medium_dimen)),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(text = "Skip", textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.primary)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevScreen() {
    GameScreen()
}
















