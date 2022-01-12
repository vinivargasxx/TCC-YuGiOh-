package br.com.cwi.yugioh_app.presentation.feature.products.viewholder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.yugioh_app.R
import br.com.cwi.yugioh_app.databinding.ItemCardBinding
import br.com.cwi.yugioh_app.domain.entity.Card
import com.bumptech.glide.Glide

class CardViewHolder(
    itemView: View,
    private val onDeckClick: (Card) -> Unit,
    private val onCardClick: (Card) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val tvName = ItemCardBinding.bind(itemView).tvName
    private val tvType = ItemCardBinding.bind(itemView).tvType
    private val ivSmallImage = ItemCardBinding.bind(itemView).ivSmallImage
    private val ivDeck = ItemCardBinding.bind(itemView).ivDeck
 
    fun bind(item: Card) {
        tvName.text = item.name
        tvType.text = item.type

        with(ivDeck) {
            setImageDrawable(getFavoriteIcon(item))
            setOnClickListener {
                item.isDeck = !item.isDeck
                setImageDrawable(getFavoriteIcon(item))
                onDeckClick(item)
            }
        }

        Glide.with(itemView.context)
            .load(item.cardSmallImage)
            .into(ivSmallImage)

        itemView.setOnClickListener {
            onCardClick(item)
        }
    }

    private fun getFavoriteIcon(card: Card) = ContextCompat.getDrawable(
        itemView.context,
        if (card.isDeck) R.drawable.ic_favorite_filled
        else R.drawable.ic_favorite_rounded
    )
}