package br.com.cwi.yugioh_app.data.network.mapper

import br.com.cwi.yugioh_app.data.network.entity.DataResponse
import br.com.cwi.yugioh_app.domain.entity.Data

class DataMapper: DomainMapper<DataResponse, Data> {

    override fun toDomain(from: DataResponse) = Data(
        products = CardMapper().toDomain(from.cards)
    )

    override fun toDomain(from: List<DataResponse>) = from.map {
        toDomain(it)
    }

}