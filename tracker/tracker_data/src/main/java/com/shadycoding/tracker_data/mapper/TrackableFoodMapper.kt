package com.shadycoding.tracker_data.mapper

import com.shadycoding.tracker_data.remote.dto.Product
import com.shadycoding.tracker_domain.model.TrackableFood
import kotlin.math.roundToInt

fun Product.toTrackableFood(): TrackableFood? {
    val carbPer100g = nutriments.carbohydrates100g.roundToInt()
    val proteinPer100g = nutriments.proteins100g.roundToInt()
    val fatPer100g = nutriments.fat100g.roundToInt()
    val caloriesPer100g = nutriments.energyKcal100g.roundToInt()

    return TrackableFood(
        name = productName ?: return null,
        carbsPer100g = carbPer100g,
        proteinPer100g = proteinPer100g,
        fatPer100g = fatPer100g,
        caloriesPer100g = caloriesPer100g,
        imageUrl = imageFrontThumbUrl
    )
}