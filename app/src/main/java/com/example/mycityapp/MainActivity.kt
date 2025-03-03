package com.example.mycityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.data.Category
import com.example.mycityapp.data.local.LocalCategoryDataProvider
import com.example.mycityapp.data.subCategoriesKeyFeatures
import com.example.mycityapp.ui.LondopediaApp
import com.example.mycityapp.ui.LondopediaAppCategories
import com.example.mycityapp.ui.LondopediaAppCategoryDetailScreen
import com.example.mycityapp.ui.LondopediaScreens
import com.example.mycityapp.ui.theme.MyCityAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MyCityAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = LondopediaScreens.Home.name
                    ) {
                        composable(route = LondopediaScreens.Home.name) {
                            LondopediaApp(
                                onExploreClicked = {
                                    navController.navigate(LondopediaScreens.MainCategory.name)
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable(route = LondopediaScreens.MainCategory.name) {
                            LondopediaAppCategories(
                                categories = LocalCategoryDataProvider.rootCategories,
                                modifier = Modifier.padding(innerPadding),
                                onArrowClicked = {
                                    navController.navigate(LondopediaScreens.SubCategory.name)
                                }
                            )
                        }

//                        composable(route = LondopediaScreens.SubCategory.name) {
//                            LondopediaAppCategories(
//                                categories = LocalCategoryDataProvider.rootCategories,
//                                modifier = Modifier.padding(innerPadding),
//                                onArrowClicked = {
//                                    navController.navigate(LondopediaScreens.SubCategoryDetails.name)
//                                }
//                            )
//                        }

//                        composable(route = LondopediaScreens.SubCategoryDetails.name) {
//                            LocalCategoryDataProvider.subCategories[R.string.category_transportation]?.let { it1 ->
//                                subCategoriesKeyFeatures.keyFeature[R.string.transportation_underground]?.let { it2 ->
//                                    LondopediaAppCategoryDetailScreen(
//                                        category = it1.first(),
//                                        keyFeatures = it2
//                                    )
//                                }
//                            }
//                        }
                    }
                }
            }
        }
    }
}