package br.com.cwi.yugioh_app.domain.entity

class Card(
        var id: Int,
        var name: String,
        var type: String,
        var cardImage: String,
        var cardSmallImage: String,
        var description: String,
        var isDeck: Boolean = false
)