package com.burcutopcu.unittesttrain.di

import androidx.lifecycle.ViewModelProvider
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
    fun getRepository(apiManager: AppManager): PokemonRepo {
        return PokemonRepo(apiManager)
    }

    @Provides
    @Singleton
    fun getViewModelFactory(numbersRepo: PokemonRepo): ViewModelProvider.Factory {
        return MainActivityViewModelFactory(numbersRepo)
    }
}