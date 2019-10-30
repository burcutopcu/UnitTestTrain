package com.burcutopcu.unittesttrain.network.service

import com.burcutopcu.unittesttrain.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET


interface PokemonService {
     @GET("http://5db8846f177b350014ac7bc6.mockapi.io/api/pokemons")
     fun getPokemons(): Call<List<Pokemon>>
 }