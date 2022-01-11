package br.com.cwi.yugioh_app.data.network.entity

import com.squareup.moshi.Json

data class CardImagesResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "image_url") val urlImage: String,
    @Json(name = "image_url_small") val urlSmallImage: String
)