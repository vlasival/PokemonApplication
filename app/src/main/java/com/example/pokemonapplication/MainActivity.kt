package com.example.pokemonapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App(pokemonViewModel = viewModel)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PokemonList(pokemonList: List<Pokemon>) {
    LazyColumn {
        items(pokemonList) { pokemon ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberImagePainter(pokemon.sprites),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Text(text = pokemon.name, fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun App(pokemonViewModel: PokemonViewModel) {
    val pokemonList by pokemonViewModel.pokemonList.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        pokemonViewModel.fetchPokemonList()
    }

    PokemonList(pokemonList = pokemonList)
}
