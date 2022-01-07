package br.com.cwi.yugioh_app.presentation.feature.products.card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.yugioh_app.R
import br.com.cwi.yugioh_app.databinding.FragmentCardBinding
import br.com.cwi.yugioh_app.domain.entity.Card
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CardFragment : Fragment() {

    private lateinit var binding: FragmentCardBinding

    private val viewModel: CardViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.cards.observe(viewLifecycleOwner) { list ->
            setUpCoffeeRecyclerView(list)
        }
        viewModel.fetchCards()
    }

    private fun setUpCoffeeRecyclerView(list: List<Card>) {
        binding.rvCards.apply {
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            adapter = CardAdapter(list, onDeckClick = {
                viewModel.setDeck(it)
            }, onCardClick = {
                navigateToCoffeeDetail(it.id)
            })
        }
    }

    private fun navigateToCoffeeDetail(id: Int) {
        findNavController().navigate(
            R.id.cardDetailFragment,
            bundleOf(
                Pair(EXTRA_CARD_ID, id)
            )
        )
    }
}