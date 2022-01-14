package br.com.cwi.yugioh_app.presentation.feature.deck

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.yugioh_app.data.database.entity.CardEntity
import br.com.cwi.yugioh_app.domain.repository.CardLocalRepository
import br.com.cwi.yugioh_app.presentation.base.BaseViewModel

class DeckViewModel(
    private val cardLocalRepository: CardLocalRepository
) : BaseViewModel() {

    private val _deck = MutableLiveData<List<CardEntity>>()
    val deck: LiveData<List<CardEntity>> = _deck

    fun fetchDeck() {
        launch {
            val cardList = cardLocalRepository.getAll()
            _deck.postValue(cardList)
        }
    }


}


