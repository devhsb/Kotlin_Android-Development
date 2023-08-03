package com.hasib.businesscard

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasib.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
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
    showSystemUi = true
)
@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column (
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bgColor))
    ) {
        Column(
            modifier = Modifier
                .weight(4f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .background(colorResource(id = R.color.darkBlue))
                    .height(150.dp)
            )
            Text(
                text = stringResource(R.string.my_name),
                fontSize = 40.sp,
                fontWeight = FontWeight.Light,
                letterSpacing = 2.sp
            )
            Text(
                text = stringResource(R.string.title),
                color = colorResource(id = R.color.darkGreen),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 5.dp)
            )
        }

        Column (
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(bottom = 10.dp, end = 70.dp)
            ) {
               Image(
                   painter = painterResource(id = R.drawable.baseline_phone_24),
                   contentDescription = null,
                   Modifier.padding(end = 20.dp)
               )
                Text(
                    text = stringResource(R.string.phone_number),
                    modifier = Modifier.padding(start = 10.dp),
                    textAlign = TextAlign.End
                )
            }
            Row(
                modifier = Modifier.padding(bottom = 10.dp, end = 100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_share_24),
                    contentDescription = null,
                    Modifier.padding(end = 20.dp)
                )
                Text(
                    text = stringResource(R.string.username),
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Row(
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    contentDescription = null,
                    Modifier.padding(end = 20.dp)
                )
                Text(
                    text = stringResource(R.string.email),
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}