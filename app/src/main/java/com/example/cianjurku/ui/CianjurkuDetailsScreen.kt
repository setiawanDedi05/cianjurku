package com.example.cianjurku.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cianjurku.data.model.Place
import com.example.cianjurku.ui.utils.CianjurkuNavigationType

@Composable
fun CianjurkuDetailsScreen(
    modifier: Modifier = Modifier,
    place: Place,
    navigationType : CianjurkuNavigationType
) {
    Box(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .width(600 .dp)) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Image(
                modifier = modifier.fillMaxWidth(),
                painter = painterResource(id = place.image),
                contentDescription = stringResource(id = place.title),
                contentScale = if(navigationType != CianjurkuNavigationType.PERMANENT_NAVIGATION) ContentScale.FillWidth else ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier.padding(15.dp)) {
                Column {
                    Text(
                        text = stringResource(id = place.title),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = place.description),
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}