package com.example.mycityapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycityapp.R
import com.example.mycityapp.data.Category
import com.example.mycityapp.data.local.LocalCategoryDataProvider
import com.example.mycityapp.ui.theme.MyCityAppTheme
import com.example.mycityapp.ui.utils.LondopediaAppCategoryItem

@Composable
fun LondopediaAppCategories(
    categories: List<Category>,
    onArrowClicked: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.height_large))
    ) {
        items(
            categories,
            key = {category -> category.categoryName}
        ) { category ->
            LondopediaAppCategoryItem(
                category = category,
                onArrowClicked = { onArrowClicked(category) }
            )
        }
    }
}