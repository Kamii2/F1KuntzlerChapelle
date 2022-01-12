package com.example.pamkuntzlerchapelle.Liste

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamkuntzlerchapelle.R


class MaListeFragment : Fragment(R.layout.fragment_liste) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val initial = listOf("PinaColada", "Margarita", "Jus", "Puré", "J AI","PLus", "IDEE","MERDE")
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = NameAdapter(initial)
        Log.d("MaListe", "listSize ${initial.count()}")
    }
}