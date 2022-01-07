package br.com.cwi.yugioh_app.presentation.feature.products.card

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.cwi.yugioh_app.R
import br.com.cwi.yugioh_app.databinding.ActivityCardHostBinding
import br.com.cwi.yugioh_app.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val VIEW_CONTENT = 0
private const val VIEW_LOADING = 1
private const val VIEW_ERROR = 2

class CardHostActivity : BaseBottomNavigation() {

    private val viewModel: CardViewModel by viewModel()

    private lateinit var binding: ActivityCardHostBinding

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(binding.navHostContainer.id) as NavHostFragment)
            .findNavController()
    }

    override val currentTab: Int = R.id.products_menu

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupViewModel()
        setupNavController()
    }

    private fun setupNavController() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val title = when (destination.id) {
                R.id.cardFragment -> getString(R.string.txt_cards_title)
                else -> "Detalhes"
            }
            supportActionBar?.title = title
        }
    }

    private fun setupViewModel() {
        viewModel.loading.observe(this) { isLoading ->
            binding.vpCard.displayedChild = if (isLoading) VIEW_LOADING else VIEW_CONTENT
        }

        viewModel.error.observe(this) { hasError ->
            binding.vpCard.displayedChild = if (hasError) VIEW_ERROR else VIEW_CONTENT
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}