package br.com.cwi.yugioh_app.presentation.feature.products.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.yugioh_app.data.database.mapper.toEntity
import br.com.cwi.yugioh_app.domain.entity.Card
import br.com.cwi.yugioh_app.domain.repository.CardLocalRepository
import br.com.cwi.yugioh_app.domain.repository.CardRepository
import br.com.cwi.yugioh_app.presentation.base.BaseViewModel

class CardViewModel(
    private val cardRepository: CardRepository,
    private val cardLocalRepository: CardLocalRepository
) : BaseViewModel() {

    private val _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> = _cards

    fun fetchCoffees() {
        launch {
            val cardList = cardRepository.getCards()
            _cards.postValue(cardList)
        }
    }

    private fun setIsCoffeeFavorite(favoriteIdList: List<Int>, cardList: List<Card>) {
        favoriteIdList.forEach { id ->
            cardList.forEach { it.isDeck = it.id == id }
        }
    }

    fun setFavorite(card: Card) {
        val coffeeEntity = card.toEntity()
        if (card.isDeck) cardLocalRepository.add(coffeeEntity)
        else cardLocalRepository.remove(coffeeEntity)
    }

}