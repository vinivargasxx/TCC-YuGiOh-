package br.com.cwi.yugioh_app.data.database.mapper

import br.com.cwi.yugioh_app.data.database.entity.CardEntity
import br.com.cwi.yugioh_app.domain.entity.Card

fun CardEntity.toCard() = Card(
    id, name, type, cardSmallImage, cardImage, description
)

fun Card.toEntity() = CardEntity(
    id, name, type, cardSmallImage, cardImage, description
)