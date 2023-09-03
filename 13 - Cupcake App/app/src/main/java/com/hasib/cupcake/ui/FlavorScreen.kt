package com.hasib.cupcake.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hasib.cupcake.ui.Common.CupcakeAppBar
import com.hasib.cupcake.ui.Data.Flavors
import org.w3c.dom.Text


@Composable
fun FlavorScreen(){
    FlavorUi(
        appBarTitle = "Choose Flavor",
        radioButtons = Flavors().flavors
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlavorUi(
    modifier: Modifier = Modifier,
    appBarTitle: String,
    radioButtons: List<String>
) {
    var selectedGender by rememberSaveable {
        mutableStateOf("")
    }
    var nextButtonEnabled by rememberSaveable {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            CupcakeAppBar(title = appBarTitle)
        }
    ) { contentPadding ->

        Box(
            modifier = Modifier.padding(contentPadding)
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
                    .verticalScroll(enabled = true, state = ScrollState(1))
            ) {
                radioButtons.forEach { button ->
                    FlavorRadioButton(
                        flavor = button, selected = selectedGender == button,
                        onClick = {
                            selectedGender = button
                            if(!nextButtonEnabled){
                                nextButtonEnabled = true
                            }

                        }
                    )
                }
                //spacer
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Gray)
                )
                //subtotal text
                Text(
                    text = "Subtotal $2.00",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .align(alignment = Alignment.End)
                        .weight(2f)
                )
                //nextCancel buttons
                Row(
                    modifier = Modifier
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp),
                        onClick = { }
                    ) {
                        Text(text = "Cancel")
                    }

                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp),
                        onClick = { },
                        enabled = nextButtonEnabled
                    ) {
                        Text(text = "Next")
                    }
                }
            }
        }
    }
}

//Radio button
@Composable
fun FlavorRadioButton(
    modifier: Modifier = Modifier,
    flavor: String,
    selected: Boolean,
    onClick: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        //Male text
        Text(
            text = flavor

        )
    }
}









