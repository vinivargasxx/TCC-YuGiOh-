package br.com.cwi.yugioh_app.domain.entity

class Card(
        var id: Int,
        var name: String,
        var type: String,
        var description: String,
        var images: List<CardImages>,
        var isDeck: Boolean = false
)