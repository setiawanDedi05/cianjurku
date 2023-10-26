@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cianjurku.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cianjurku.R
import com.example.cianjurku.ui.theme.CianjurkuViewModel
import com.example.cianjurku.ui.utils.CianjurkuNavigationType

enum class CianjurkuScreen(@StringRes val title: Int) {
    Start(title = R.string.category),
    ListOfPlace(title = R.string.list_of_place),
    Details(title = R.string.details)
}

@Composable
fun CianjurkuApp(
    windowSize: WindowWidthSizeClass
) {
    val viewModel: CianjurkuViewModel = viewModel()
    val cianjurkuUiState = viewModel.uiState.collectAsState().value
    val navigationType: CianjurkuNavigationType
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        CianjurkuScreen.valueOf(backStackEntry?.destination?.route ?: CianjurkuScreen.Start.name)
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = CianjurkuNavigationType.SIDE_NAVIGATION
        }

        WindowWidthSizeClass.Medium -> {
            navigationType = CianjurkuNavigationType.NAVIGATION_RAIL
        }

        WindowWidthSizeClass.Expanded -> {
            navigationType = CianjurkuNavigationType.PERMANENT_NAVIGATION
        }

        else -> {
            navigationType = CianjurkuNavigationType.SIDE_NAVIGATION
        }
    }

    Scaffold(
        topBar = {
            CianjurkuAppBar(
                canNavigateBack = currentScreen.title != CianjurkuScreen.Start.title,
                currentScreenTitle = if (navigationType != CianjurkuNavigationType.SIDE_NAVIGATION) R.string.app_name else currentScreen.title,
                navigateUp = { navController.navigateUp() }
            )
        },
    ) { innerPadding ->
        when (navigationType) {
            CianjurkuNavigationType.PERMANENT_NAVIGATION -> {
                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    CianjurkuHomeScreen(
                        onCategoryPressed = { category ->
                            viewModel.updateCurrentCategory(category)
                        },
                        contentPadding = innerPadding,
                        navigationType = navigationType
                    )
                    CianjurkuPlaceScreen(
                        contentPadding = innerPadding,
                        places = cianjurkuUiState.places[cianjurkuUiState.currentCategory]
                            ?: emptyList(),
                        onPlacePressed = { place ->
                            viewModel.updateDetailScreenStates(place)
                        },
                        modifier = Modifier.width(500.dp)
                    )
                    CianjurkuDetailsScreen(
                        place = cianjurkuUiState.currentSelectedPlace,
                        navigationType = navigationType,
                    )
                }
            }

            CianjurkuNavigationType.NAVIGATION_RAIL -> {
                NavHost(
                    navController = navController,
                    startDestination = CianjurkuScreen.Start.name
                ) {
                    composable(
                        route = CianjurkuScreen.Start.name
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            CianjurkuHomeScreen(
                                onCategoryPressed = { category ->
                                    viewModel.updateCurrentCategory(category)
                                },
                                contentPadding = innerPadding,
                                navigationType = navigationType
                            )
                            CianjurkuPlaceScreen(
                                contentPadding = innerPadding,
                                places = cianjurkuUiState.places[cianjurkuUiState.currentCategory]
                                    ?: emptyList(),
                                onPlacePressed = { place ->
                                    viewModel.updateDetailScreenStates(place)
                                    navController.navigate(CianjurkuScreen.Details.name)
                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                    composable(route = CianjurkuScreen.ListOfPlace.name) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            CianjurkuHomeScreen(
                                onCategoryPressed = { category ->
                                    viewModel.updateCurrentCategory(category)
                                },
                                contentPadding = innerPadding,
                                navigationType = navigationType
                            )
                            CianjurkuPlaceScreen(
                                contentPadding = innerPadding,
                                places = cianjurkuUiState.places[cianjurkuUiState.currentCategory]
                                    ?: emptyList(),
                                onPlacePressed = { place ->
                                    viewModel.updateDetailScreenStates(place)
                                    navController.navigate(CianjurkuScreen.Details.name)
                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                    composable(route = CianjurkuScreen.Details.name) {
                        CianjurkuDetailsScreen(
                            place = cianjurkuUiState.currentSelectedPlace,
                            modifier = Modifier.fillMaxWidth(),
                            navigationType = navigationType
                        )
                    }
                }
            }

            else -> {
                NavHost(
                    navController = navController,
                    startDestination = CianjurkuScreen.Start.name
                ) {
                    composable(
                        route = CianjurkuScreen.Start.name
                    ) {
                        CianjurkuHomeScreen(
                            onCategoryPressed = { category ->
                                viewModel.updateCurrentCategory(category)
                                navController.navigate(CianjurkuScreen.ListOfPlace.name)
                            },
                            contentPadding = innerPadding,
                            navigationType = navigationType,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    composable(route = CianjurkuScreen.ListOfPlace.name) {
                        CianjurkuPlaceScreen(
                            contentPadding = innerPadding,
                            places = cianjurkuUiState.places[cianjurkuUiState.currentCategory]
                                ?: emptyList(),
                            onPlacePressed = { place ->
                                viewModel.updateDetailScreenStates(place)
                                navController.navigate(CianjurkuScreen.Details.name)
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    composable(route = CianjurkuScreen.Details.name) {
                        CianjurkuDetailsScreen(
                            place = cianjurkuUiState.currentSelectedPlace,
                            modifier = Modifier.fillMaxWidth(),
                            navigationType = navigationType
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CianjurkuAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}
