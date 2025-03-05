package com.example.mycityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.data.Category
import com.example.mycityapp.data.local.LocalCategoryDataProvider
import com.example.mycityapp.data.subCategoriesKeyFeatures
import com.example.mycityapp.ui.LondopediaApp
import com.example.mycityapp.ui.LondopediaAppCategories
import com.example.mycityapp.ui.LondopediaAppCategoryDetailScreen
import com.example.mycityapp.ui.LondopediaScreens
import com.example.mycityapp.ui.LondopediaViewModel
import com.example.mycityapp.ui.theme.MyCityAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val londopediaViewModel: LondopediaViewModel = viewModel()
            val londopediaUiState = londopediaViewModel.londopediaUiState.collectAsState()
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentScreen = LondopediaScreens.valueOf(
                backStackEntry?.destination?.route ?: LondopediaScreens.Home.name
            )

            MyCityAppTheme {
                Scaffold(
                    topBar = { TopAppBar(
                        currentScreen = currentScreen,
                        currentScreenTitle = londopediaUiState.value.currentScreenTitle,
                        navigateUp = {
                            londopediaViewModel.updateTopAppBarTitle()
                            navController.navigateUp()
                        }
                    ) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = LondopediaScreens.Home.name
                    ) {
                        composable(route = LondopediaScreens.Home.name) {
                            LondopediaApp(
                                onExploreClicked = {
                                    londopediaViewModel.updateCategories()
                                    navController.navigate(LondopediaScreens.MainCategory.name)
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable(route = LondopediaScreens.MainCategory.name) {
                            LondopediaAppCategories(
                                categories = londopediaUiState.value.categories,
                                modifier = Modifier.padding(innerPadding),
                                onArrowClicked = { it ->
                                    londopediaViewModel.updateSubCategories(it)
                                    navController.navigate(LondopediaScreens.SubCategory.name)
                                },
                                onSystemBackTriggered = { navController.navigateUp() }
                            )
                        }

                        composable(route = LondopediaScreens.SubCategory.name) {
                            londopediaUiState.value.subCategories?.let {
                                LondopediaAppCategories(
                                    categories = it,
                                    modifier = Modifier.padding(innerPadding),
                                    onArrowClicked = { it ->
                                        londopediaViewModel.updateKeyFeatures(it)
                                        navController.navigate(LondopediaScreens.SubCategoryDetails.name)
                                    },
                                    onSystemBackTriggered = {
                                        londopediaViewModel.updateTopAppBarTitle()
                                        navController.navigateUp()
                                    }
                                )
                            }
                        }

                        composable(route = LondopediaScreens.SubCategoryDetails.name) {
                            londopediaUiState.value.keyFeature?.let {
                                LondopediaAppCategoryDetailScreen(
                                    category = londopediaUiState.value.currentSelectedCategory,
                                    keyFeatures = it,
                                    onBackClicked = {
                                        navController.navigateUp()
                                    },
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBar(
    currentScreen: LondopediaScreens,
    currentScreenTitle: Int,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (currentScreen == LondopediaScreens.MainCategory || currentScreen == LondopediaScreens.SubCategory) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(currentScreenTitle),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = navigateUp
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            }
        )
    }
}