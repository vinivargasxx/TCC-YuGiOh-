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
    private val tvTitle = ItemCardBinding.bind(itemView).tvTitle
    private val tvSubtitle = ItemCardBinding.bind(itemView).tvSubtitle
    private val ivImage = ItemCardBinding.bind(itemView).ivImage
    private val ivFavorite = ItemCardBinding.bind(itemView).ivFavorite
 
    fun bind(item: Card) {
        tvTitle.text = item.name
        tvSubtitle.text = item.description

        with(ivFavorite) {
            setImageDrawable(getFavoriteIcon(item))
            setOnClickListener {
                item.isDeck = !item.isDeck
                setImageDrawable(getFavoriteIcon(item))
                onDeckClick(item)
            }
        }

        Glide.with(itemView.context)
            .load(item.urlImage)
            .into(ivImage)

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