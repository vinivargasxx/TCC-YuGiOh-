package br.com.cwi.yugioh_app.data.database.dao

import androidx.room.*
import br.com.cwi.yugioh_app.data.database.entity.CardEntity

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(cardEntity: CardEntity)

    @Delete
    fun remove(cardEntity: CardEntity)

    @Query("SELECT * FROM CardEntity")
    fun getAll(): List<CardEntity>?
}