package br.com.cwi.yugioh_app.data.database.mapper

import br.com.cwi.yugioh_app.data.database.entity.CardEntity
import br.com.cwi.yugioh_app.domain.entity.Card

fun CardEntity.toCard() = Card(
    id, name, type, race, attribute, atk, def, lvl, cardSmallImage, cardImage, description
)

fun Card.toEntity() = CardEntity(
    id, name, type, race, attribute, atk, def, lvl, cardSmallImage, cardImage, description
)