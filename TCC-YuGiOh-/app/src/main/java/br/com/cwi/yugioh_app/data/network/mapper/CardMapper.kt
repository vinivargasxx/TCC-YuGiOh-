package br.com.cwi.yugioh_app.data.network.mapper

import br.com.cwi.yugioh_app.data.network.entity.CardResponse
import br.com.cwi.yugioh_app.domain.entity.Card

class CardMapper: DomainMapper<CardResponse, Card> {

    override fun toDomain(from: CardResponse) = Card(
        id = from.id,
        name = from.name,
        description = from.description,
        type = from.type,
        cardSmallImage = from.cardImages[0].urlSmallImage,
        cardImage = from.cardImages[0].urlImage
    )


    override fun toDomain(from: List<CardResponse>) = from.map {
        toDomain(it)
    }
}