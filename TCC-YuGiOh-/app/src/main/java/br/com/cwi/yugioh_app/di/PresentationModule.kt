package br.com.cwi.yugioh_app.di


import br.com.cwi.yugioh_app.presentation.feature.products.card.CardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CardViewModel(get(), get()) }

}