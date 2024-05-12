package com.example.pokemonapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(PokemonAPI::class.java)

    suspend fun getPokemonList(): List<Pokemon> {
        return service.getPokemonList().results.map { result ->
            val id = result.url.split("/").dropLast(1).last()
            Pokemon(id.toInt(), result.name, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png")
        }
    }
}