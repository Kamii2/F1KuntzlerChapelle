package com.example.pamkuntzlerchapelle

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
/*
    Fragment pour l'affichage de la map Google.
 */
class MapsFragment : Fragment() {

    /* Point par default */
    private val callback = OnMapReadyCallback { googleMap ->
        val clermontFerrand = LatLng( 45.7797, 3.08694)
        googleMap.addMarker(MarkerOptions().position(clermontFerrand).title("Marker in Clermont-Ferrand"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(clermontFerrand))
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}