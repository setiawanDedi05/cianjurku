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
import com.example.cianjurku.data.model.Category
import com.example.cianjurku.ui.utils.CianjurkuNavigationType

@Composable
fun CianjurkuHomeScreen(
    onCategoryPressed: (Category) -> Unit,
    contentPadding: PaddingValues,
    navigationType: CianjurkuNavigationType,
    modifier: Modifier = Modifier
){
    val categories = enumValues<Category>()
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
                categories,
                key = { category -> category.title }
            ){
                CategoryItemList(
                    modifier = modifier,
                    onCategoryPressed = onCategoryPressed,
                    category = it,
                    navigationType = navigationType
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryItemList(
    modifier: Modifier = Modifier,
    onCategoryPressed: (Category) -> Unit,
    category: Category,
    navigationType: CianjurkuNavigationType
){
    Card(
        modifier = modifier
            .padding(8.dp)
            .height(80.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        onClick = {
            onCategoryPressed(category)
        }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = category.icon),
                contentDescription = stringResource(id = category.title),
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp),
                contentScale = ContentScale.Crop
            )
            if(navigationType == CianjurkuNavigationType.SIDE_NAVIGATION) Spacer(modifier = Modifier.width(50 .dp))
            if(navigationType == CianjurkuNavigationType.SIDE_NAVIGATION) Text(text = stringResource(id = category.title), color = Color.Black, style = MaterialTheme.typography.titleLarge)
        }
    }
}