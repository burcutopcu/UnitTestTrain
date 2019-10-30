package com.burcutopcu.unittesttrain.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.burcutopcu.unittesttrain.network.repo.PokemonRepo
import javax.inject.Inject

class MainActivityViewModelFactory @Inject
constructor(private val pokemonRepo: PokemonRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(pokemonRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}