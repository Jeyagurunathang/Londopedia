package com.example.mycityapp.ui

import com.example.mycityapp.R
import com.example.mycityapp.data.Category
import com.example.mycityapp.data.local.LocalCategoryDataProvider

data class LondopediaUiState(
    val categories: List<Category> = LocalCategoryDataProvider.rootCategories,
    val subCategories: List<Category>? = LocalCategoryDataProvider.subCategories[R.string.category_transportation],
    val currentSelectedCategory: Category = Category(),
    val keyFeature: List<Int>? = null,
    val currentScreenTitle: Int = 0
)