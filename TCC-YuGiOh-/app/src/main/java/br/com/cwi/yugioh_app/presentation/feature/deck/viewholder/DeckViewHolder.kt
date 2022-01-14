package br.com.cwi.yugioh_app.presentation.feature.deck.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.yugioh_app.data.database.entity.CardEntity
import br.com.cwi.yugioh_app.databinding.ItemCardDeckBinding
import com.bumptech.glide.Glide

class DeckViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    private val tvCardTitle = ItemCardDeckBinding.bind(itemView).tvCardTitle
    private val ivSmallImage = ItemCardDeckBinding.bind(itemView).ivSmallImage

    fun bind(item: CardEntity) {
        tvCardTitle.text = item.name
        Glide.with(itemView.context)
            .load(item.cardSmallImage)
            .into(ivSmallImage)

    }

}