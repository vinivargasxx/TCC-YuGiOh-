package br.com.cwi.yugioh_app.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val race: String,
    val attribute: String?,
    var atk: Int?,
    var def: Int?,
    var lvl: Int?,
    val cardSmallImage: String,
    val cardImage: String,
    val description: String
)