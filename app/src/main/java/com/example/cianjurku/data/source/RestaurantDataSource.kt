package com.example.cianjurku.data.source

import com.example.cianjurku.R
import com.example.cianjurku.data.model.Category
import com.example.cianjurku.data.model.Place

object DataSource {
    val allPlaces = listOf(
        Place(
            title = R.string.alam_sunda,
            image = R.drawable.alam_sunda,
            description = R.string.description,
            category = Category.Restaurant
        ),
        Place(
            title = R.string.ampera,
            image = R.drawable.ampera,
            description = R.string.description,
            category = Category.Restaurant
        ),
        Place(
            title = R.string.ibc,
            image = R.drawable.ibc,
            description = R.string.description,
            category = Category.Restaurant
        ),
        Place(
            title = R.string.imah,
            image = R.drawable.imah,
            description = R.string.description,
            category = Category.CoffeeShop
        ),
        Place(
            title = R.string.ujala,
            image = R.drawable.ujala,
            description = R.string.description,
            category = Category.CoffeeShop
        ),
        Place(
            title = R.string.starbuck,
            image = R.drawable.starbuck,
            description = R.string.description,
            category = Category.CoffeeShop
        ),
        Place(
            title = R.string.et_al,
            image = R.drawable.et_al,
            description = R.string.description,
            category = Category.CoffeeShop
        ),
        Place(
            title = R.string.wardis,
            image = R.drawable.wardis,
            description = R.string.description,
            category = Category.CoffeeShop
        ),
        Place(
            title = R.string.the_nice,
            image = R.drawable.the_nice,
            description = R.string.description,
            category = Category.KidFriendly
        ),
        Place(
            title = R.string.the_john,
            image = R.drawable.the_john,
            description = R.string.description,
            category = Category.KidFriendly
        ),
        Place(
            title = R.string.cianjur_city_park,
            image = R.drawable.cianjur_cirk,
            description = R.string.description,
            category = Category.KidFriendly
        ),
        Place(
            title = R.string.alun_alun,
            image = R.drawable.alun_alun,
            description = R.string.description,
            category = Category.Park
        ),
        Place(
            title = R.string.joglo,
            image = R.drawable.joglo,
            description = R.string.description,
            category = Category.Park
        ),
        Place(
            title = R.string.prawatasari,
            image = R.drawable.prawita_sari,
            description = R.string.description,
            category = Category.Park
        ),
        Place(
            title = R.string.city_mall,
            image = R.drawable.city_mall,
            description = R.string.description,
            category = Category.Shopping
        ),
        Place(
            title = R.string.ciplaz,
            image = R.drawable.ciplaz,
            description = R.string.description,
            category = Category.Shopping
        ),
        Place(
            title = R.string.hypermart,
            image = R.drawable.hyper_mart,
            description = R.string.description,
            category = Category.Shopping
        )
    )

}