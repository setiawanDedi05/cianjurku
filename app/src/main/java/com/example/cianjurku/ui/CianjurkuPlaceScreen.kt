package com.example.cianjurku.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cianjurku.data.model.Place
import com.example.cianjurku.data.source.DataSource

@Composable
fun CianjurkuPlaceScreen(
    contentPadding: PaddingValues,
    onPlacePressed: (Place) -> Unit,
    modifier: Modifier = Modifier,
    places: List<Place>
){
    Box(
        modifier = modifier.padding(
            top = contentPadding.calculateTopPadding(),
            start = 8 .dp,
            end = 8 .dp
        )
    ){
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(2 .dp)
        ){
            items(
                places,
                key = { place -> place.title }
            ){
                PlaceItemList(
                    modifier = modifier,
                    onPlacePressed = onPlacePressed,
                    place = it
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceItemList(
    modifier: Modifier = Modifier,
    onPlacePressed: (Place) -> Unit,
    place: Place
){
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(80.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        onClick = { onPlacePressed(place) }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = place.image),
                contentDescription = stringResource(id = place.title),
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(
                modifier = Modifier.width(50 .dp)
            )
            Text(
                text = stringResource(
                    id = place.title
                ),
                color = Color.Black,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}