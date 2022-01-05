package br.com.cwi.yugioh_app.data.repository

import br.com.cwi.yugioh_app.data.database.AppDatabase
import br.com.cwi.yugioh_app.data.database.entity.CardEntity
import br.com.cwi.yugioh_app.domain.repository.CardLocalRepository

class CardLocalRepositoryImpl(
    appDatabase: AppDatabase
) : CardLocalRepository {

    private val dao = appDatabase.getCardDao()

    override fun add(cardEntity: CardEntity) {
        dao.add(cardEntity)
    }

    override fun remove(cardEntity: CardEntity) {
        dao.remove(cardEntity)
    }

    override fun getAll(): List<CardEntity>? = dao.getAll()
}