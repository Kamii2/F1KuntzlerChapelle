package com.example.pamkuntzlerchapelle.Liste

import Cocktail
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pamkuntzlerchapelle.R
import com.squareup.picasso.Picasso

/*
    Creation et definition des cellules de la liste de cocktails.
 */
class NameAdapter(
    val cocktailList: List<Cocktail>, val cocktailCallBack: OnCocktailListener) : RecyclerView.Adapter<Cellule>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cellule {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.cell, parent, false)
        return Cellule(view)
    }
    /* Instanciation des cellules et mises a jour des informations et de la detection du clic */
    override fun onBindViewHolder(cellule: Cellule, position: Int) {
        cellule.itemTextView.text = cocktailList[position].name
        Picasso.get().load(cocktailList[position].URL).into(cellule.itemImageView);
        cellule.itemView.setOnClickListener{
            cocktailCallBack.onCocktailClicked(cocktailList[position].name, cocktailList[position].URL,cocktailList[position].instruction)
        }
    }

    /* Callback de l'appui sur une cellule. */
    fun interface OnCocktailListener{
        fun onCocktailClicked (cocktail : String, url : String, instruction : String)
    }

    /* Renvoi le nombre d'elements de la liste (pas utilisé) */
    override fun getItemCount(): Int {
        return cocktailList.count()
    }
}

/* Definition de la classe Cellule */
class Cellule(view: View) : RecyclerView.ViewHolder(view) {
        var itemImageView: ImageView = view.findViewById(R.id.imageRecette)
        var itemTextView: TextView = view.findViewById(R.id.Recette)
    }