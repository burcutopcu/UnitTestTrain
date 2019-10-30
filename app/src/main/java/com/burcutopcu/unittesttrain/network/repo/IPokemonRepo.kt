package com.burcutopcu.unittesttrain.network.repo

import com.burcutopcu.unittesttrain.app.IServiceResponseCallback
import com.burcutopcu.unittesttrain.model.Pokemon

interface IPokemonRepo {
    fun getPokemonList(callback: IServiceResponseCallback<List<Pokemon>>)
}