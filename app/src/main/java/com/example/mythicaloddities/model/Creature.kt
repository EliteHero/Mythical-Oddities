package com.example.mythicaloddities.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Creature(
    val id: Int,
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val detailResourceId: Int
)