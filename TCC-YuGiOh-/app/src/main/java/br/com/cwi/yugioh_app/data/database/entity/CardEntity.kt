package br.com.cwi.yugioh_app.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val cardSmallImage: String,
    val cardImage: String,
    val description: String
)