package br.com.cwi.yugioh_app.domain.entity

class Card(
        var id: Int,
        var name: String,
        var type: String,
        var race: String,
        var attribute: String?,
        var atk: Int?,
        var def: Int?,
        var lvl: Int?,
        var cardImage: String,
        var cardSmallImage: String,
        var description: String,
        var isDeck: Boolean = false
)