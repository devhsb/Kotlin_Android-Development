package com.hasib.admin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.dp
import com.hasib.admin.ui.theme.QuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuotesAdminApp(addContent = {quote ->
                        run {
                            AdminAppContent.sendQuote(this, quote)
                        }
                    })
                }
            }
        }
    }
}
@Composable
fun QuotesAdminApp(addContent: (String) -> Unit) {
    Column {
        Text(text = "Admin App")
        AddQuotesForm(addContent = addContent)
    }
}

object AdminAppContent {
    val ADD_QUOTE = "com.hasib.ADD_QUOTE"

    fun sendQuote(context: Context, quote: String) {
        val intent = Intent(ADD_QUOTE)
            .putExtra("quote", quote)
        context.sendBroadcast(intent)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddQuotesForm(addContent: (String) -> Unit, modifier: Modifier = Modifier) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        TextField(
            value = text,
            onValueChange = {text = it},
            label = { Text(text = "Enter Quote")},
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
        Button(onClick = {addContent(text)},
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)

        ) {
            Text(text = "Save")
        }
    }
}


