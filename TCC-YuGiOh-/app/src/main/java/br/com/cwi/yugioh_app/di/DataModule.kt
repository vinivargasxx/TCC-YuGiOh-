package br.com.cwi.yugioh_app.di

import br.com.cwi.yugioh_app.data.database.AppDatabase
import br.com.cwi.yugioh_app.data.network.RetrofitConfig
import br.com.cwi.yugioh_app.data.network.mapper.CardMapper
import br.com.cwi.yugioh_app.data.repository.CardLocalRepositoryImpl
import br.com.cwi.yugioh_app.data.repository.CardRepositoryImpl
import br.com.cwi.yugioh_app.domain.repository.CardLocalRepository
import br.com.cwi.yugioh_app.domain.repository.CardRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { CardMapper() }
    single { AppDatabase.create(androidApplication()) }

    factory<CardRepository> { CardRepositoryImpl(get(), get()) }
    factory<CardLocalRepository> { CardLocalRepositoryImpl(get()) }
}