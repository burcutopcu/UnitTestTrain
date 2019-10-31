package com.burcutopcu.unittesttrain.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.burcutopcu.unittesttrain.app.IServiceResponseCallback
import com.burcutopcu.unittesttrain.model.Pokemon
import com.burcutopcu.unittesttrain.network.repo.PokemonRepo
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MainActivityViewModel @Inject
constructor(private val pokemonRepo: PokemonRepo) : ViewModel() {

    val pokemonListSubject: BehaviorSubject<List<Pokemon>> = BehaviorSubject.create()

    fun getPokemonList() {
        pokemonRepo.getPokemonList(object : IServiceResponseCallback<List<Pokemon>> {
            override fun onServerError(error: String?) {
                Log.i("tag", error)
            }

            override fun onServerCompleted(t: List<Pokemon>) {
                pokemonListSubject.onNext(t)
            }

            override fun onServerCompleted() {
                Log.i("tag", "")
            }
        })
    }
}