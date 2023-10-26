package com.example.cianjurku.ui.theme

import com.example.cianjurku.data.model.Category
import com.example.cianjurku.data.model.Place
import com.example.cianjurku.data.source.DataSource

data class CianjurkuUiState(
    val places: Map<Category, List<Place>> = emptyMap(),
    val currentCategory: Category = Category.Restaurant,
    val currentSelectedPlace: Place = DataSource.allPlaces[0],
    val isShowingHomepage: Boolean = true
){
    val currentPlaceOfCategory: List<Place> by lazy { places[currentCategory]!! }
}
