package com.example.pamkuntzlerchapelle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Acceuil.newInstance] factory method to
 * create an instance of this fragment.
 */
class Acceuil : Fragment() {
//https://www.androidauthority.com/use-web-api-android-1152645/
//https://www.thecocktaildb.com/api.php
//https://stackoverflow.com/questions/45219379/how-to-make-an-api-request-in-kotlin/45219917
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val client = HttpClient()
        val response: HttpResponse = client.request("www.thecocktaildb.com/api/json/v1/1/random.php") {
            method = HttpMethod.Get
        }
        }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Acceuil.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Acceuil().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}