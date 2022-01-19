package com.example.pamkuntzlerchapelle.Liste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pamkuntzlerchapelle.R
import com.squareup.picasso.Picasso

class NameAdapter(
    val nameList: MutableList<String>,
    val htppList: MutableList<String>, val cocktailCallBack: OnCocktailListener) : RecyclerView.Adapter<Cellule>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cellule {

        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.cell, parent, false)
        return Cellule(view)
    }

    override fun onBindViewHolder(cellule: Cellule, position: Int) {
        cellule.itemTextView.text = nameList[position]
        Picasso.get().load(htppList[position]).into(cellule.itemImageView);
        cellule.itemView.setOnClickListener{
            cocktailCallBack.onCocktailClicked(nameList[position])
        }
    }

    fun interface OnCocktailListener{
        fun onCocktailClicked (cocktail : String)
    }

    override fun getItemCount(): Int {
        return nameList.count()
    }
}
class Cellule(view: View) : RecyclerView.ViewHolder(view) {
        var itemImageView: ImageView = view.findViewById(R.id.imageRecette)
        var itemTextView: TextView = view.findViewById(R.id.Recette)
    }