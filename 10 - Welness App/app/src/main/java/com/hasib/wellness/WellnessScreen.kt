package com.hasib.wellness

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasib.wellness.model.DailyProgram
import com.hasib.wellness.model.Repository


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayxCard(
    modifier: Modifier = Modifier,
    program: DailyProgram
) {
    var expandDesc by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.small_dimen)),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        onClick = {expandDesc = !expandDesc}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.medium_dimen))
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMediumLow
                    )
                )
        ) {
            Text(
                text = program.day,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = program.title
            )
            Image(
                painter = painterResource(id = program.image),
                contentDescription = program.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.medium_dimen)),
                contentScale = ContentScale.Crop
            )
            if(expandDesc) {
                Text(
                    text = program.description,
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.large_dimen)),
                    lineHeight = 20.sp
                )
            }
        }
    }
}

@Composable
fun WellnessList(modifier: Modifier = Modifier, programs: List<DailyProgram> = Repository().dayxProgram(),
                    contentPadding: PaddingValues) {
    LazyColumn(contentPadding = contentPadding) {
        items(programs) {
            DayxCard(program = it)
        }
    }
}