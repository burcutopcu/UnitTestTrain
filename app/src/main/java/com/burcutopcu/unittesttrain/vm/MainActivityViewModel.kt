package com.burcutopcu.unittesttrain.vm
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
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onServerCompleted(t: List<Pokemon>) {
                pokemonListSubject.onNext(t)
            }

            override fun onServerCompleted() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}