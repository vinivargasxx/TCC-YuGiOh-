package br.com.cwi.yugioh_app.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.cwi.yugioh_app.domain.entity.CardImages

@Entity
data class CardEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val images: List<CardImages>,
    val description: String
)