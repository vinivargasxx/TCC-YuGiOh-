package br.com.cwi.yugioh_app.di

import org.koin.core.module.Module

val appModules : List<Module> = listOf(dataModule, presentationModule)