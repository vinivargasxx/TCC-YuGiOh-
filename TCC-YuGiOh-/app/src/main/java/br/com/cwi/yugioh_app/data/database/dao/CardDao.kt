package br.com.cwi.yugioh_app.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.cwi.yugioh_app.data.database.entity.CardEntity

@Dao
interface CardDao {

    @Insert
    fun add(cardEntity: CardEntity)

    @Delete
    fun remove(cardEntity: CardEntity)

    @Query("SELECT * FROM CardEntity")
    fun getAll(): List<CardEntity>?
}