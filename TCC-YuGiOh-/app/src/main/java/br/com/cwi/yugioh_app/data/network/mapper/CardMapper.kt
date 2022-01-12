package br.com.cwi.yugioh_app.data.network.mapper

import br.com.cwi.yugioh_app.data.network.entity.CardResponse
import br.com.cwi.yugioh_app.domain.entity.Card

const val FIRST_OBJECT_IN_LIST_IMAGE = 0

class CardMapper: DomainMapper<CardResponse, Card> {

    override fun toDomain(from: CardResponse) = Card(
        id = from.id,
        name = from.name,
        type = from.type,
        description = from.description,
        atk = from.attack,
        def = from.defense,
        lvl = from.level,
        race = from.race,
        attribute = from.attribute,
        cardSmallImage = from.cardImages[FIRST_OBJECT_IN_LIST_IMAGE].urlSmallImage,
        cardImage = from.cardImages[FIRST_OBJECT_IN_LIST_IMAGE].urlImage
    )


    override fun toDomain(from: List<CardResponse>) = from.map {
        toDomain(it)
    }
}