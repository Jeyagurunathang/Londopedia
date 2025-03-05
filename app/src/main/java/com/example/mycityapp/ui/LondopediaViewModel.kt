package com.example.mycityapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mycityapp.R
import com.example.mycityapp.data.Category
import com.example.mycityapp.data.local.LocalCategoryDataProvider
import com.example.mycityapp.data.subCategoriesKeyFeatures
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LondopediaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LondopediaUiState())

    val londopediaUiState: StateFlow<LondopediaUiState> = _uiState.asStateFlow()

    fun updateCategories() {
        updateTopAppBarTitle()
        _uiState.update {
            it.copy(
                categories = LocalCategoryDataProvider.rootCategories
            )
        }
    }

    fun updateSubCategories(category: Category) {
        updateTopAppBarTitle(category)
        _uiState.update {
            it.copy(
                currentSelectedCategory = category,
                subCategories = LocalCategoryDataProvider.subCategories[category.categoryName]
            )
        }
    }

    fun updateKeyFeatures(category: Category) {
        _uiState.update {
            it.copy(
                currentSelectedCategory = category,
                keyFeature = subCategoriesKeyFeatures.keyFeature[category.categoryName]
            )
        }
    }

    private fun updateTopAppBarTitle(category: Category? = null) {
        _uiState.update {
            it.copy(
                currentScreenTitle = category?.categoryName ?: R.string.home
            )
        }
    }
}