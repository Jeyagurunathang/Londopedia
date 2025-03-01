package com.example.mycityapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycityapp.R
import com.example.mycityapp.data.Category
import com.example.mycityapp.data.local.LocalCategoryDataProvider
import com.example.mycityapp.ui.theme.MyCityAppTheme

@Composable
fun Category(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(
            categories,
            key = {category -> category.categoryName}
        ) { category ->
            CategoryItem(category = category)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryPreview() {
    MyCityAppTheme {
        Category(
            categories = LocalCategoryDataProvider.rootCategories
        )
    }
}