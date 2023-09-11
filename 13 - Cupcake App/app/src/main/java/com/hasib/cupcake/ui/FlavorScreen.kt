package com.hasib.cupcake.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hasib.cupcake.R
import com.hasib.cupcake.ui.CupcakeViewModel.CupcakeViewModel
import com.hasib.cupcake.ui.Data.Flavors


@Composable
fun FlavorScreen(
    onNextButtonClicked: () -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    subtotal: Int,
    cupcakeViewModel: CupcakeViewModel
){
    FlavorUi(
        appBarTitle = "Choose Flavor",
        radioButtons = Flavors().flavors,
        onNextButtonClicked = onNextButtonClicked,
        onCancelButtonClicked = onCancelButtonClicked,
        subtotal = subtotal,
        cupcakeViewModel = cupcakeViewModel
    )
}

@Composable
fun FlavorUi(
    modifier: Modifier = Modifier,
    appBarTitle: String,
    radioButtons: List<String>,
    onNextButtonClicked: () -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    subtotal: Int,
    cupcakeViewModel: CupcakeViewModel
) {
    var selectedGender by rememberSaveable {
        mutableStateOf("")
    }
    var nextButtonEnabled by rememberSaveable {
        mutableStateOf(false)
    }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .verticalScroll(enabled = true, state = ScrollState(1))
            ) {
                radioButtons.forEach { button ->
                    FlavorRadioButton(
                        flavor = button, selected = selectedGender == button,
                        onClick = {
                            if(Flavors().flavors.contains(button)) {
                                cupcakeViewModel.updateUi(flavor = button)
                            }else {
                                cupcakeViewModel.updateUi(pickupDate = button)
                            }
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
                        text = stringResource(R.string.subtotal, subtotal),
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .align(alignment = Alignment.End)
                            .weight(1f)
                    )

                //nextCancel buttons
                Row() {
                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp),
                        onClick = onCancelButtonClicked
                    ) {
                        Text(text = "Cancel")
                    }

                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp),
                        onClick = onNextButtonClicked,
                        enabled = nextButtonEnabled
                    ) {
                        Text(text = "Next")
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









