package com.example.cianjurku.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cianjurku.R

enum class Category(@StringRes val title: Int, @DrawableRes val icon: Int){
    Restaurant(title = R.string.restaurant, icon = R.drawable.restaurant),
    CoffeeShop(title = R.string.coffee, icon = R.drawable.coffee),
    KidFriendly(title = R.string.kid_friendly, icon = R.drawable.playtime),
    Park(title = R.string.park, icon = R.drawable.park),
    Shopping(title = R.string.shopping_center, icon = R.drawable.shopping_cart)
}

data class Place (
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int,
    val category: Category
)

