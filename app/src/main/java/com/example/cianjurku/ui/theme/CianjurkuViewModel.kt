package com.example.cianjurku.ui.theme

import androidx.lifecycle.ViewModel
import com.example.cianjurku.data.model.Category
import com.example.cianjurku.data.model.Place
import com.example.cianjurku.data.source.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CianjurkuViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(CianjurkuUiState())
    val uiState: StateFlow<CianjurkuUiState> = _uiState
    init {
        initializeUIState()
    }
    private fun initializeUIState(){
        val places: Map<Category, List<Place>> = DataSource.allPlaces.groupBy { it.category }
        _uiState.value = CianjurkuUiState(
            places = places,
            currentSelectedPlace = places[Category.Restaurant]?.get(0) ?: DataSource.allPlaces[0]
        )
    }

    fun updateDetailScreenStates(place: Place){
        _uiState.update {
            it.copy(
                currentSelectedPlace = place,
                isShowingHomepage = false
            )
        }
    }
    fun resetHomeScreenStates(){
        _uiState.update {
            it.copy(
                currentSelectedPlace = it.places[it.currentCategory]?.get(0) ?: DataSource.allPlaces[0],
                isShowingHomepage = true
            )
        }
    }

    fun updateCurrentCategory(category: Category){
        _uiState.update {
            it.copy(
                currentCategory = category
            )
        }
    }
}