package com.burcutopcu.unittesttrain.network.service

import com.burcutopcu.unittesttrain.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET


interface PokemonService {
    @GET("api/pokemons")
     fun getPokemons(): Call<List<Pokemon>>
 }