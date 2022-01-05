package br.com.cwi.yugioh_app.domain.repository

import br.com.cwi.yugioh_app.data.database.entity.CardEntity

interface CardLocalRepository {
    fun add(cardEntity: CardEntity)
    fun remove(cardEntity: CardEntity)
    fun getAll(): List<CardEntity>?
}