package com.hasib.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasib.superheroes.Data.Data
import com.hasib.superheroes.Model.Superhero
import com.hasib.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroesApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            )
        }
    ) {
        HeroesList(contentPadding = it, heroes = Data().getSuperheroes())
    }
}

@Composable
fun HeroesList(
    modifier: Modifier = Modifier,
    heroes: List<Superhero>,
    contentPadding: PaddingValues
) {
    LazyColumn(contentPadding = contentPadding){
        items(heroes) {
            HeroesCard(hero = it)
        }
    }
}

@Composable
fun HeroesCard(
    modifier: Modifier = Modifier,
    hero: Superhero
) {
    Card(
        modifier = Modifier.padding(
            dimensionResource(id = R.dimen.small_dimen)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    dimensionResource(id = R.dimen.small_dimen)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(end = dimensionResource(id = R.dimen.medium_dimen))
            ) {
                Text(
                    text = hero.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = hero.description
                )
            }
//            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = hero.image),
                contentDescription = hero.title,
                modifier = Modifier
                    .size(70.dp)
                    .clip(shape = RoundedCornerShape(20))
            )
        }
    }
}


//@Preview
@Composable
fun CardPreview() {
    SuperheroesTheme(darkTheme = false) {
        HeroesCard(hero = Data().getSuperheroes().get(1))
    }
}


@Preview(showSystemUi = true)
@Composable
fun HeroesListPreview() {
    SuperheroesTheme(darkTheme = true) {
        HeroesApp()
    }
}











