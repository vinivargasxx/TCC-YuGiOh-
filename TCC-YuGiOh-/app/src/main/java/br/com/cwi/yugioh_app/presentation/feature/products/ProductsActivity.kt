package br.com.cwi.yugioh_app.presentation.feature.products

import android.content.Intent
import android.os.Bundle
import br.com.cwi.yugioh_app.R
import br.com.cwi.yugioh_app.databinding.ActivityProductsBinding
import br.com.cwi.yugioh_app.presentation.base.BaseBottomNavigation
import br.com.cwi.yugioh_app.presentation.feature.products.card.CardHostActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProductsActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityProductsBinding

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpProductActions()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    private fun setUpProductActions() {
        binding.contentCards.title = "Cards"
        binding.contentCards.setOnClickListener {
            val intent = Intent(this, CardHostActivity::class.java)
            startActivity(intent)
        }
    }

}