package com.example.mycityapp.data.local

import com.example.mycityapp.R
import com.example.mycityapp.data.Category

object LocalCategoryDataProvider {
    val rootCategories = listOf<Category>(
        Category(
            categoryName = R.string.category_transportation,
            categoryDescription = R.string.category_transportation_description,
            categoryImage = R.drawable.cycling
        ),
        Category(
            categoryName = R.string.category_bridge,
            categoryDescription = R.string.category_bridge_description,
            categoryImage = R.drawable.tower_bridge
        ),
        Category(
            categoryName = R.string.category_attraction,
            categoryDescription = R.string.category_attraction_description,
            categoryImage = R.drawable.big_ben
        ),
        Category(
            categoryName = R.string.category_park,
            categoryDescription = R.string.category_park_description,
            categoryImage = R.drawable.hyde_park
        )
    )

    val subCategories = mapOf<Int, List<Category>>(
        R.string.category_transportation to listOf(
            Category(
                categoryName = R.string.transportation_underground,
                categoryDescription = R.string.transportation_underground_description,
                categoryImage = R.drawable.underground
            ),
            Category(
                categoryName = R.string.transportation_bus,
                categoryDescription = R.string.category_transportation_description,
                categoryImage = R.drawable.bus
            ),
            Category(
                categoryName = R.string.transportation_taxi,
                categoryDescription = R.string.transportation_taxi_description,
                categoryImage = R.drawable.taxi
            ),
            Category(
                categoryName = R.string.transportation_dlr,
                categoryDescription = R.string.transportation_dlr_description,
                categoryImage = R.drawable.dlr_train
            ),
            Category(
                categoryName = R.string.transportation_cycle,
                categoryDescription = R.string.transportation_cycling_description,
                categoryImage = R.drawable.cycling
            ),
            Category(
                categoryName = R.string.transportation_airways,
                categoryDescription = R.string.transportation_airways_description,
                categoryImage = R.drawable.airway
            )
        ),

        R.string.category_bridge to listOf(
            Category(
                categoryName = R.string.bridge_tower_bridge,
                categoryDescription = R.string.bridge_tower_bridge_description,
                categoryImage = R.drawable.tower_bridge
            ),
            Category(
                categoryName = R.string.bridge_westminster_bridge,
                categoryDescription = R.string.bridge_westminster_bridge_description,
                categoryImage = R.drawable.westminster_bridge
            ),
            Category(
                categoryName = R.string.bridge_london_eye,
                categoryDescription = R.string.bridge_london_eye_description,
                categoryImage = R.drawable.london_eye
            ),
            Category(
                categoryName = R.string.bridge_shard,
                categoryDescription = R.string.bridge_shard_description,
                categoryImage = R.drawable.shard
            )
        ),

        R.string.category_park to listOf(
            Category(
                categoryName = R.string.park_hyde,
                categoryDescription = R.string.park_hyde_description,
                categoryImage = R.drawable.hyde_park,
                categoryEstablishedDate = R.string.hyde_park_established
            ),
            Category(
                categoryName = R.string.park_regents,
                categoryDescription = R.string.park_regent_description,
                categoryImage = R.drawable.regent_park,
                categoryEstablishedDate = R.string.regents_park_established
            ),
            Category(
                categoryName = R.string.park_richmond,
                categoryDescription = R.string.park_richmond_description,
                categoryImage = R.drawable.richmond_park,
                categoryEstablishedDate = R.string.richmond_park_established
            ),
            Category(
                categoryName = R.string.park_greenwich,
                categoryDescription = R.string.park_greenwich_description,
                categoryImage = R.drawable.greenwich_park,
                categoryEstablishedDate = R.string.greenwich_park_established
            )
        ),

        R.string.category_attraction to listOf(
            Category(
                categoryName = R.string.attraction_tower_of_london,
                categoryDescription = R.string.attraction_tower_of_london_description,
                categoryImage = R.drawable.tower_of_london,
                categoryEstablishedDate = R.string.london_tower_established
            ),
            Category(
                categoryName = R.string.attraction_buckingham_palace,
                categoryDescription = R.string.attraction_buckingham_palace_description,
                categoryImage = R.drawable.buckingham_palace,
                categoryEstablishedDate = R.string.buckingham_palace_established
            ),
            Category(
                categoryName = R.string.attraction_westminster_abbey,
                categoryDescription = R.string.attraction_westminster_abbey_description,
                categoryImage = R.drawable.westminster_abbey,
                categoryEstablishedDate = R.string.westminster_abbey_established
            ),
            Category(
                categoryName = R.string.attraction_paul_cathedral,
                categoryDescription = R.string.attraction_paul_cathedral_description,
                categoryImage = R.drawable.st_pauls_cathedral,
                categoryEstablishedDate = R.string.st_pauls_cathedral_established
            ),
            Category(
                categoryName = R.string.attraction_big_ben,
                categoryDescription = R.string.attraction_big_ben_description,
                categoryImage = R.drawable.big_ben,
                categoryEstablishedDate = R.string.big_ben_established
            ),
            Category(
                categoryName = R.string.attraction_windsor_castle,
                categoryDescription = R.string.attraction_windsor_castle_description,
                categoryImage = R.drawable.windsor_castle,
                categoryEstablishedDate = R.string.windsor_castle_established
            )
        )
    )
}