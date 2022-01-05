package br.com.cwi.yugioh_app.data.repository

import br.com.cwi.yugioh_app.data.network.NespressoApi
import br.com.cwi.yugioh_app.data.network.mapper.CardMapper
import br.com.cwi.yugioh_app.domain.entity.Card
import br.com.cwi.yugioh_app.domain.repository.CardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CardRepositoryImpl(
    private val api: NespressoApi,
    private val cardMapper: CardMapper
) : CardRepository {

    override suspend fun getCards(): List<Card> {
        return withContext(Dispatchers.IO) {
            cardMapper.toDomain(api.getCards())
        }
    }

}