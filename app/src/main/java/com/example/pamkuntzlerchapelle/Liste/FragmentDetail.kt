package com.example.pamkuntzlerchapelle.Liste

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pamkuntzlerchapelle.R
import com.squareup.picasso.Picasso

/*
    Fragment pour l'affichage du detail du cocktail.
 */
class FragmentDetail : Fragment(R.layout.fragment_detail) {
    val args: FragmentDetailArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var itemImageView: ImageView = view.findViewById(R.id.imageRecette)
        var itemTextView: TextView = view.findViewById(R.id.Recette)
        var itemTextView2: TextView = view.findViewById(R.id.Instruction)
        itemTextView.text = args.nom
        itemTextView2.text = args.instruction
        Picasso.get().load(args.url).into(itemImageView);
    }
}
