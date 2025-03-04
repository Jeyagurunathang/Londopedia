package com.example.mycityapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mycityapp.R

data class Category(
    @StringRes val categoryName: Int = R.string.category_transportation,
    @StringRes val categoryDescription: Int = R.string.category_transportation_description,
    @DrawableRes val categoryImage: Int = R.drawable.bus,
    @StringRes val categoryEstablishedDate: Int? = null
)