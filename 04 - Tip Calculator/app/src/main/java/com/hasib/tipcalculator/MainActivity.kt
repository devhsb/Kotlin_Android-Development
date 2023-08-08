package com.hasib.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasib.tipcalculator.ui.theme.TipCalculatorTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipLayout()
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TipLayout(modifier: Modifier = Modifier) {
    var tipAmount by remember {
        mutableStateOf("")
    }
    var percantage by remember {
        mutableStateOf("")
    }
    var roundUp by remember {
        mutableStateOf(false)
    }
    val amount = tipAmount.toDoubleOrNull() ?: 0.0
    val percent = percantage.toDoubleOrNull() ?: 0.0
    val calculatedTip = calculateTip(amount, percent, roundUp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip_text),
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 30.dp)
        )

        TipTextField(
            tipAmount = tipAmount,
            label = R.string.bill_amount_text,
            icon = R.drawable.icons8_cashbook_50,
            imeAction = ImeAction.Next,
            onValueChange = {tipAmount = it}
            )
        TipTextField(
            tipAmount = percantage,
            label = R.string.percentage_text,
            icon = R.drawable.icons8_percentage_64,
            imeAction = ImeAction.Done,
            onValueChange = {percantage = it},
            modifier = Modifier.padding(top = 30.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)
        ) {
           Text(
               text = stringResource(R.string.round_text)
           )

            Switch(
                checked = roundUp,
                onCheckedChange = {roundUp = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            )
        }

        Text(
            text = stringResource(R.string.tip_amount_text, calculatedTip),
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 30.dp)
        )
        Spacer(modifier = Modifier.height(200.dp))
    }
}

@Composable
fun TipTextField(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    @DrawableRes icon: Int,
    tipAmount: String,
    imeAction: ImeAction,
    onValueChange: (String) -> Unit
) {

    TextField(
        value = tipAmount,
        onValueChange = onValueChange,
        label = {Text(text = stringResource(label))},
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        ),
        leadingIcon = {Icon(painter = painterResource(id = icon), contentDescription = null)},
        singleLine = true,
        modifier = modifier.fillMaxWidth()
    )
}

private fun calculateTip(tipAmount: Double, percantage: Double = 15.0, roundUp: Boolean): String {
    var result = (percantage / 100) * tipAmount
    if(roundUp) {
        result = kotlin.math.ceil(result)
    }
    return NumberFormat.getCurrencyInstance().format(result)
}