package com.example.mycityapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mycityapp.R

data class LocalFacilityDetailDataTemplate(
    @StringRes val facilityName: Int = R.string.category_transportation,
    @StringRes val facilityDescription: Int = R.string.category_transportation_description,
    @DrawableRes val facilityImage: Int = R.drawable.bus,
    @StringRes val establishDate: Int
)