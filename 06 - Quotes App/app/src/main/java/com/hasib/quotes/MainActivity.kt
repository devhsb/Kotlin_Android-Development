package com.hasib.quotes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hasib.quotes.data.Quotes
import com.hasib.quotes.model.Quote
import com.hasib.quotes.ui.theme.QuotesTheme
import com.hasib.admin.AdminAppContent
import com.hasib.admin.QuotesAdminApp

class MainAppReciever : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == AdminAppContent.ADD_QUOTE) {
            val content = intent.getStringExtra("quote")
        }
    }

}

class MainActivity : ComponentActivity() {
    private val reciever = MainAppReciever()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuotesApp()
                    QuotesAdminApp(addContent = { quote ->
                        run {
                            AdminAppContent.sendQuote(this, quote)
                        }
                    })
                }
            }
        }
        registerReceiver(reciever, IntentFilter(AdminAppContent.ADD_QUOTE))
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun QuotesApp() {
    QuoteList(quotesList = Quotes().loadQuotes())
}

@Composable
fun QuoteList(quotesList: List<Quote>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(quotesList){ quote ->
            QuotesCard(
                quote = quote,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
        }
    }
}

@Composable
fun QuotesCard(quote: Quote, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.cardColor)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = quote.imageId),
                contentDescription = stringResource(id = quote.textId),
                modifier = Modifier
                    .height(40.dp)
                    .clip(shape = RoundedCornerShape(50))
            )
            Text(
                text = stringResource(id = quote.textId),
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}













