package com.example.pamkuntzlerchapelle.Liste

import Cocktail
import MyViewModel
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamkuntzlerchapelle.R

/*
    Fragment pour l'affichage de la liste des cocktails.
 */
class MaListeFragment : Fragment(R.layout.fragment_liste){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* Gestion et affichage de la liste de cocktails. */
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val model: MyViewModel by viewModels()
        model.getCocktails().observe(viewLifecycleOwner, Observer<List<Cocktail>>{
            recyclerView.adapter = NameAdapter(it){ name,url,instruction ->
                findNavController().navigate(MaListeFragmentDirections.actionShowDetailToFragmentDetail(name,url,instruction))
            }
        })

        /* Bouton pour l'affichage de la map Google */
        var mapButton: Button = view.findViewById(R.id.findBarButton)
        mapButton.setOnClickListener { view ->
            findNavController().navigate(MaListeFragmentDirections.actionShowDetailToMapsFragment())
        }
    }
}