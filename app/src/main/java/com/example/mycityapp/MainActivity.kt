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
import com.example.mycityapp.data.local.LocalCategoryDataProvider
import com.example.mycityapp.data.subCategoriesKeyFeatures
import com.example.mycityapp.ui.LondopediaApp
import com.example.mycityapp.ui.LondopediaAppCategoryDetailScreen
import com.example.mycityapp.ui.theme.MyCityAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCityAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    LondopediaApp(modifier = Modifier.padding(innerPadding))
//                    Category(
//                        categories = LocalCategoryDataProvider.rootCategoriesSubItems,
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    LocalCategoryDataProvider.subCategories[R.string.category_transportation]?.let {
                        LondopediaAppCategoryDetailScreen(
                            it.first(),
                            keyFeatures = subCategoriesKeyFeatures.keyFeature[R.string.transportation_underground] ?: listOf(R.string.transportation_underground),
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LondopediaPreview() {
    MyCityAppTheme {
        LondopediaApp()
    }
}