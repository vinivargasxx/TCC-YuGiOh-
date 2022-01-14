package br.com.cwi.yugioh_app.data.repository

import br.com.cwi.yugioh_app.data.network.ITENS_PAGINA
import br.com.cwi.yugioh_app.data.network.YugiohApi
import br.com.cwi.yugioh_app.data.network.mapper.DataMapper
import br.com.cwi.yugioh_app.domain.entity.Data
import br.com.cwi.yugioh_app.domain.repository.CardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CardRepositoryImpl(
    private val api: YugiohApi,
    private val dataMapper: DataMapper
) : CardRepository {

    override suspend fun getCards(page: Int): Data {
        return withContext(Dispatchers.IO) {
            dataMapper.toDomain(api.getCards(ITENS_PAGINA * page))
        }
    }


}