package com.hasib.lemonade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hasib.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LemonadeApp() {
    LemonadeProcess(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeProcess(
    modifier: Modifier = Modifier
) {
    var id by remember {
        mutableStateOf(1)
    }
    var multiTap by remember {
        mutableStateOf(0)
    }

    var text by remember {
        mutableStateOf(R.string.lemon_tree_text)
    }
    val imageid = when(id) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(imageid),
            contentDescription = "Lemon tree",
            modifier = Modifier
                .size(200.dp)
                .background(
                    Color(195, 236, 200),
                    shape = RoundedCornerShape(40.dp)
                )
                .padding(20.dp)

//                Click listener
                .clickable {
                    when (id) {
                        1 -> {
                            id++
                            multiTap = (2..4).random()
                            text = R.string.lemon_tapping_text
                        }

                        2 -> {
                            multiTap--
                            if (multiTap == 0) {
                                id++
                                text = R.string.drink_lemon_text
                            }
                        }

                        3 -> {
                            id++
                            text = R.string.lemon_restard_text
                        }

                        else -> {
                            id = 1
                            text = R.string.lemon_tree_text
                        }
                    }
                }
        )
        Spacer(modifier = Modifier.size(30.dp))
        Text(
            text = stringResource(text)
        )
    }
}

