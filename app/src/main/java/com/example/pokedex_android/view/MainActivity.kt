 package com.example.pokedex_android.view

 import android.os.Bundle
 import androidx.appcompat.app.AppCompatActivity
 import androidx.recyclerview.widget.LinearLayoutManager
 import androidx.recyclerview.widget.RecyclerView
 import com.example.pokedex_android.R
 import com.example.pokedex_android.domain.Pokemon
 import com.example.pokedex_android.domain.PokemonType

 class MainActivity : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPokemons)

         val charmander: Pokemon = Pokemon(
             "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/004.png",
             "Charmander",
             1,
             listOf(
                 PokemonType("Fire")
             )
         )

         val pokemons = listOf(charmander, charmander, charmander, charmander, charmander)

         val layoutManager = LinearLayoutManager(this)

         recyclerView.layoutManager = layoutManager
         recyclerView.adapter = PokemonAdapter(pokemons)
     }
}