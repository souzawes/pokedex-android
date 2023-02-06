package com.example.pokedex_android.domain

data class Pokemon(
    val imageUrl: String,
    val name: String,
    val number: Int,
    val types: List<PokemonType>
) {
    val formattedNumber = number.toString().padStart(3, '0')
}

