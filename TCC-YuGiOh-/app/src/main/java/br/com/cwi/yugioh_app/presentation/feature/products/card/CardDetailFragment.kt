package br.com.cwi.yugioh_app.presentation.feature.products.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.cwi.yugioh_app.databinding.FragmentCardDetailBinding
import com.bumptech.glide.Glide

const val EXTRA_CARD_ID = "EXTRA_CARD_ID"
const val EXTRA_CARD_IMAGE = "EXTRA_CARD_IMAGE"
const val EXTRA_CARD_NAME = "EXTRA_CARD_NAME"
const val EXTRA_CARD_TYPE = "EXTRA_CARD_TYPE"
const val EXTRA_CARD_RACE = "EXTRA_CARD_RACE"
const val EXTRA_CARD_ATTRIBUTE = "EXTRA_CARD_ATTIBUTE"
const val EXTRA_CARD_ATTACK = "EXTRA_CARD_ATTACK"
const val EXTRA_CARD_DEFENSE = "EXTRA_CARD_DEFENSE"
const val EXTRA_CARD_LEVEL = "EXTRA_CARD_LEVEL"
const val EXTRA_CARD_DESCRIPTION = "EXTRA_CARD_DESCRIPTION"

class CardDetailFragment : Fragment() {

    private lateinit var binding: FragmentCardDetailBinding

    private val cardId by lazy {
        arguments?.getInt(EXTRA_CARD_ID)
    }
    private val cardImage by lazy {
        arguments?.getString(EXTRA_CARD_IMAGE)
    }
    private val cardName by lazy {
        arguments?.getString(EXTRA_CARD_NAME)
    }
    private val cardType by lazy {
        arguments?.getString(EXTRA_CARD_TYPE)
    }
    private val cardRace by lazy {
        arguments?.getString(EXTRA_CARD_RACE)
    }
    private val cardAttribute by lazy {
        arguments?.getString(EXTRA_CARD_ATTRIBUTE)
    }
    private val cardAttack by lazy {
        arguments?.getInt(EXTRA_CARD_ATTACK)
    }
    private val cardDefense by lazy {
        arguments?.getInt(EXTRA_CARD_DEFENSE)
    }
    private val cardLevel by lazy {
        arguments?.getInt(EXTRA_CARD_LEVEL)
    }
    private val cardDescription by lazy {
        arguments?.getString(EXTRA_CARD_DESCRIPTION)
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
        binding.tvCardName.text = cardName.toString()
        binding.tvCardType.text = cardType.toString()
        binding.tvCardRace.text = cardRace.toString()
        binding.tvCardAttribute.text = cardAttribute.toString()
        binding.tvCardAttack.text = cardAttack.toString()
        binding.tvCardDefense.text = cardDefense.toString()
        binding.tvCardLevel.text = cardLevel.toString()
        binding.tvCardDescription.text = cardDescription.toString()

        Glide.with(view.context)
            .load(cardImage)
            .into(binding.ivCardDetailImage)

    }

}