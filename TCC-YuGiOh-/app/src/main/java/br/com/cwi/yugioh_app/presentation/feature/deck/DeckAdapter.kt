package br.com.cwi.yugioh_app.presentation.feature.deck

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.yugioh_app.R
import br.com.cwi.yugioh_app.data.database.entity.CardEntity
import br.com.cwi.yugioh_app.presentation.feature.deck.viewholder.DeckViewHolder

class DeckAdapter(
    private val list: List<CardEntity>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = inflateView(R.layout.item_card_deck, parent)
        return DeckViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        (viewHolder as DeckViewHolder).bind(item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)



}