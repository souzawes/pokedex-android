package com.example.pokedex_android.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex_android.R
import com.example.pokedex_android.domain.Pokemon
import com.example.pokedex_android.domain.PokemonType

class PokemonAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return viewHolder(view)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) = with(itemView) {
            /**
             * Switch use the methods findViewById by bindings
             */
            val imageViewPokemon = findViewById<ImageView>(R.id.imageViewPokemon)
            val textViewNumber = findViewById<TextView>(R.id.textViewNumber)
            val textViewName = findViewById<TextView>(R.id.textViewName)
            val textViewFirstType = findViewById<TextView>(R.id.textViewFirstType)
            val textViewSecondType = findViewById<TextView>(R.id.textViewSecondType)

            // TODO: Load image with Glade

            textViewNumber.text = "Nº ${item.formattedNumber}"
            textViewName.text = item.name
            textViewFirstType.text = item.types[0].name

            if (hasSecondType(item.types)) {
                textViewSecondType.visibility = View.VISIBLE
                textViewSecondType.text = item.types[1].name
            } else {
                textViewSecondType.visibility = View.GONE
            }

        }

        private fun hasSecondType(listTypesPokemon: List<PokemonType>): Boolean {
            return listTypesPokemon.size > 1
        }
    }
}