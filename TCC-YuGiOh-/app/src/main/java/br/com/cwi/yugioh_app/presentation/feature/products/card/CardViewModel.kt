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

    private var nextPage = 0

    private val _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> = _cards

    fun fetchCards() {
        launch {
            val cardList = cardRepository.getCards(nextPage)
            _cards.postValue(cardList.cards)
        }
    }

    private fun setIsCardDeck(deckIdList: List<Int>, cardList: List<Card>) {
        deckIdList.forEach { id ->
            cardList.forEach { it.isDeck = it.id == id }
        }
    }

    fun setDeck(card: Card) {
        val cardEntity = card.toEntity()
        if (card.isDeck) cardLocalRepository.add(cardEntity)
        else cardLocalRepository.remove(cardEntity)
    }



}