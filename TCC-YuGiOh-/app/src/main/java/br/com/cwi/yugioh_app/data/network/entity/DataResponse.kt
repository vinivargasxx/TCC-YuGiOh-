package br.com.cwi.yugioh_app.data.network.entity

import com.squareup.moshi.Json

data class DataResponse(
    @Json(name = "data") val cards: List<CardResponse>
)