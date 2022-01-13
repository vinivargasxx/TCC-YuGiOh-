package br.com.cwi.yugioh_app.presentation.feature.deck

import android.content.Intent
import android.os.Bundle
import br.com.cwi.yugioh_app.R
import br.com.cwi.yugioh_app.databinding.ActivityDeckBinding
import br.com.cwi.yugioh_app.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class DeckActivity : BaseBottomNavigation() {



    private lateinit var binding: ActivityDeckBinding

    override val currentTab: Int = R.id.deck_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeckBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root


}