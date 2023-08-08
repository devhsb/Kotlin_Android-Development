package com.hasib.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
    val amount = tipAmount.toDoubleOrNull() ?: 0.0

    val calculatedTip = calculateTip(amount)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip_text),
            fontSize = 24.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(30.dp))
        TipTextField(
            modifier = modifier,
            tipAmount = tipAmount,
            onValueChange = {tipAmount = it}
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(R.string.tip_amount_text, calculatedTip),
            fontSize = 20.sp
        )
    }
}

@Composable
fun TipTextField(
    modifier: Modifier = Modifier,
    tipAmount: String,
    onValueChange: (String) -> Unit
) {

    TextField(
        value = tipAmount,
        onValueChange = onValueChange,
        label = {
            Text(text = stringResource(R.string.bill_amount_text))
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

private fun calculateTip(tipAmount: Double, percantage: Double = 15.0): String {
    val result = (percantage / 100) * tipAmount
    return NumberFormat.getCurrencyInstance().format(result)
}