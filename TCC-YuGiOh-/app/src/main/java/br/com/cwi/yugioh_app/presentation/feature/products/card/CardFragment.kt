package br.com.cwi.yugioh_app.presentation.feature.products.card

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.cwi.yugioh_app.R
import br.com.cwi.yugioh_app.databinding.FragmentCardBinding
import br.com.cwi.yugioh_app.domain.entity.Card
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CardFragment : Fragment() {

    lateinit var listFiltered: List<Card>
    private lateinit var binding: FragmentCardBinding

    private val viewModel: CardViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.cards.observe(viewLifecycleOwner) { list ->
            listFiltered = list
            setUpCardRecyclerView(list)

        }
        viewModel.fetchCards()
    }

    private fun setUpCardRecyclerView(list: List<Card>) {
        binding.rvCards.apply {

            adapter = CardAdapter(list, onDeckClick = {
                viewModel.setDeck(it)
            }, onCardClick = {
                navigateToCardDetail(
                    it.id,
                    it.name,
                    it.cardImage,
                    it.type,
                    it.race,
                    it.attribute,
                    it.atk,
                    it.def,
                    it.description,
                    it.lvl
                )
            })
        }
    }

    private fun navigateToCardDetail(
        id: Int, name: String,
        cardImage: String,
        type: String,
        race: String,
        attribute: String?,
        attack: Int?,
        defense: Int?,
        description: String,
        level: Int?
    ) {
        findNavController().navigate(
            R.id.cardDetailFragment,
            bundleOf(
                Pair(EXTRA_CARD_ID, id),
                Pair(EXTRA_CARD_IMAGE, cardImage),
                Pair(EXTRA_CARD_NAME, name),
                Pair(EXTRA_CARD_TYPE, type),
                Pair(EXTRA_CARD_RACE, race),
                Pair(EXTRA_CARD_ATTRIBUTE, attribute),
                Pair(EXTRA_CARD_ATTACK, attack),
                Pair(EXTRA_CARD_DEFENSE, defense),
                Pair(EXTRA_CARD_LEVEL, level),
                Pair(EXTRA_CARD_DESCRIPTION, description)
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu, menu)

        val search = menu.findItem(R.id.search).actionView as SearchView

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchFilter(query)
                return true
            }
            override fun onQueryTextChange(query: String?): Boolean {
                searchFilter(query)
                return true
            }
        })
    }

    private fun searchFilter(query: String?) {
        val filteredList = listFiltered.filter {
            if(query != null) {
                it.name.lowercase().contains(query.lowercase())
            } else true
        }
        setUpCardRecyclerView(filteredList)
    }

}