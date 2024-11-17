package com.example.mythicaloddities.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    val id: Int,
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val descResourceId: Int,
    @StringRes val detailResourceId: Int
)
