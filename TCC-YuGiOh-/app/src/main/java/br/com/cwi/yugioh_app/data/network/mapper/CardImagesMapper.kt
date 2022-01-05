package br.com.cwi.yugioh_app.data.network.mapper

import br.com.cwi.yugioh_app.data.network.entity.CardImagesResponse
import br.com.cwi.yugioh_app.domain.entity.CardImages

class CardImagesMapper: DomainMapper<CardImagesResponse, CardImages> {

    override fun toDomain(from: CardImagesResponse) = CardImages(
        id = from.id,
        urlImage = from.urlImage,
        urlSmallImage = from.urlSmallImage
    )


    override fun toDomain(from: List<CardImagesResponse>) = from.map {
        toDomain(it)
    }
}