package com.burcutopcu.unittesttrain.network.repo

import com.burcutopcu.unittesttrain.app.AppManager
import com.burcutopcu.unittesttrain.app.IServiceResponseCallback
import com.burcutopcu.unittesttrain.model.Pokemon
import com.burcutopcu.unittesttrain.network.service.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PokemonRepo @Inject constructor(appManager: AppManager): IPokemonRepo {

    private var pokemonService: PokemonService = appManager.createRetrofitService(PokemonService::class.java)

    override fun getPokemonList(callback: IServiceResponseCallback<List<Pokemon>>) {
        pokemonService.getPokemons().enqueue(object : Callback<List<Pokemon>> {
            override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
                if (response.isSuccessful && response.body() != null) {
                    callback.onServerCompleted(response.body()!!)
                } else
                    callback.onServerError("")
            }

            override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
                callback.onServerError("")
            }
        })
    }
}