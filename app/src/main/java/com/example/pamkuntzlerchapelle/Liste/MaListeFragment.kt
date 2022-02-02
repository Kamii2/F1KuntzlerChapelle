package com.example.pamkuntzlerchapelle.Liste

import Cocktail
import MyViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamkuntzlerchapelle.R
import com.google.gson.annotations.SerializedName

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.*


class MaListeFragment : Fragment(R.layout.fragment_liste){
    val mon_api = API()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val model: MyViewModel by viewModels()
        model.getCocktails().observe(this, Observer<List<Cocktail>>{
            recyclerView.adapter = NameAdapter(it){ name,url,instruction ->
                findNavController().navigate(MaListeFragmentDirections.actionShowDetailToFragmentDetail(name,url,instruction))
            }
        })
    }
}