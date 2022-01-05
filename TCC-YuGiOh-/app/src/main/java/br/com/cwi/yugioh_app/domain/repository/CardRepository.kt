package br.com.cwi.yugioh_app.domain.repository

import br.com.cwi.yugioh_app.domain.entity.Card

interface CardRepository {
    suspend fun getCards(): List<Card>
}