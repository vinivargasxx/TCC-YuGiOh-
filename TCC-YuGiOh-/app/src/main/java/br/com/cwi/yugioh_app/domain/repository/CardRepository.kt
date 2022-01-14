package br.com.cwi.yugioh_app.domain.repository

import br.com.cwi.yugioh_app.domain.entity.Data

interface CardRepository {
    suspend fun getCards(page: Int): Data

}