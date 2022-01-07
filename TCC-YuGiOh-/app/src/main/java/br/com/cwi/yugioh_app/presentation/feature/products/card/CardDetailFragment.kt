package br.com.cwi.yugioh_app.presentation.feature.products.card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cwi.yugioh_app.databinding.FragmentCardDetailBinding

const val EXTRA_CARD_ID = "EXTRA_CARD_ID"

class CardDetailFragment : Fragment() {

    private lateinit var binding: FragmentCardDetailBinding

    private val cardId by lazy {
        arguments?.getInt(EXTRA_CARD_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCards.text = cardId.toString()
    }

}