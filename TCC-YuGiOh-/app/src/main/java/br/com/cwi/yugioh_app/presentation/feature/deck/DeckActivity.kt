package br.com.cwi.yugioh_app.presentation.feature.deck

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import br.com.cwi.yugioh_app.R
import br.com.cwi.yugioh_app.data.database.entity.CardEntity
import br.com.cwi.yugioh_app.databinding.ActivityDeckBinding

import br.com.cwi.yugioh_app.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

import org.koin.androidx.viewmodel.ext.android.viewModel

private const val VIEW_CONTENT = 0
private const val VIEW_LOADING = 1
private const val VIEW_ERROR = 2

class DeckActivity: BaseBottomNavigation() {

    private val viewModel: DeckViewModel by viewModel()

    private lateinit var binding: ActivityDeckBinding

    override val currentTab: Int = R.id.deck_menu

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.deck.observe(this@DeckActivity) { list ->
            setUpDeckRecyclerView(list)
        }

        viewModel.loading.observe(this) { isLoading ->
            binding.vpDeck.displayedChild = if (isLoading) VIEW_LOADING else VIEW_CONTENT
        }

        viewModel.error.observe(this) { hasError ->
            binding.vpDeck.displayedChild = if (hasError) VIEW_ERROR else VIEW_CONTENT
        }

        viewModel.fetchDeck()
    }

    private fun setUpDeckRecyclerView(list: List<CardEntity>) {
        binding.rvDeck.apply {
            addItemDecoration(
                DividerItemDecoration(this@DeckActivity, DividerItemDecoration.VERTICAL)
            )
            adapter = DeckAdapter(list)
            layoutManager = GridLayoutManager(context, 3)
        }
    }

}