package br.com.cwi.yugioh_app.presentation.feature.products.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.yugioh_app.R
import br.com.cwi.yugioh_app.domain.entity.Card
import br.com.cwi.yugioh_app.presentation.feature.products.viewholder.CardViewHolder

class CardAdapter(
    private var list: List<Card>,
    private val onDeckClick: (Card) -> Unit,
    private val onCardClick: (Card) -> Unit
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflateView(R.layout.item_card, parent)
        return CardViewHolder(view, onDeckClick, onCardClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = list[position]
        (viewHolder as CardViewHolder).bind(item)
    }


    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)


}