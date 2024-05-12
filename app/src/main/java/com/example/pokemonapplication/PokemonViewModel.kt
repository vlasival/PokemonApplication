package com.example.pokemonapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PokemonViewModel(private val api: PokemonAPI) : ViewModel() {
    private val repository = PokemonRepository()

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    fun fetchPokemonList() {
        viewModelScope.launch {
            _pokemonList.value = repository.getPokemonList()
        }
    }
}