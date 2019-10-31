package com.burcutopcu.unittesttrain.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.burcutopcu.unittesttrain.activity.MainActivity
import com.burcutopcu.unittesttrain.app.AppManager
import com.burcutopcu.unittesttrain.network.repo.PokemonRepo
import com.burcutopcu.unittesttrain.vm.MainActivityViewModel
import com.burcutopcu.unittesttrain.vm.MainActivityViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}

@Module
class MainActivityModule {

    @Provides
    @Singleton
    fun provideNumberViewModel(
        activity: MainActivity,
        factory: MainActivityViewModelFactory
    ): MainActivityViewModel {
        return ViewModelProviders.of(activity, factory).get(MainActivityViewModel::class.java)
    }

    @Provides
    @Singleton
    fun getRepository(apiManager: AppManager): PokemonRepo {
        return PokemonRepo(apiManager)
    }

    @Provides
    @Singleton
    fun getViewModelFactory(pokemonRepo: PokemonRepo): ViewModelProvider.Factory {
        return MainActivityViewModelFactory(pokemonRepo)
    }
}