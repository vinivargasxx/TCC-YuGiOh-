package br.com.cwi.yugioh_app.data.network.entity

import com.squareup.moshi.Json

data class CardResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "type") val type: String,
    @Json(name = "desc") val description: String,
    @Json(name = "card_images") val cardImages: List<CardImagesResponse>,
)
