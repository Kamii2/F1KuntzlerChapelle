package com.example.pamkuntzlerchapelle.Liste

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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

@Serializable
data class Result(val drinks: List<Drinks>)

@Serializable
data class Drinks(
    val idDrink: String? = null,
    val strDrink: String? = null,
    val strDrinkAlternate: String? = null,
    val strTags: String? = null,
    val strVideo: String? = null,
    val strCategory: String? = null,
    val strIBA: String? = null,
    val strAlcoholic: String? = null,
    val strGlass: String? = null,
    val strInstructions: String? = null,
    val strInstructionsES: String? = null,
    val strInstructionsDE: String? = null,
    val strInstructionsFR: String? = null,
    val strInstructionsIT: String? = null,
    @SerializedName("strInstructionsZH-HANS")
    val strInstructionsZHHANS: String? = null,
    @SerializedName("strInstructionsZH-HANT")
    val strInstructionsZHHANT: String? = null,
    val strDrinkThumb: String? = null,
    val strIngredient1: String? = null,
    val strIngredient2: String? = null,
    val strIngredient3: String? = null,
    val strIngredient4: String? = null,
    val strIngredient5: String? = null,
    val strIngredient6: String? = null,
    val strIngredient7: String? = null,
    val strIngredient8: String? = null,
    val strIngredient9: String? = null,
    val strIngredient10: String? = null,
    val strIngredient11: String? = null,
    val strIngredient12: String? = null,
    val strIngredient13: String? = null,
    val strIngredient14: String? = null,
    val strIngredient15: String? = null,
    val strMeasure1: String? = null,
    val strMeasure2: String? = null,
    val strMeasure3: String? = null,
    val strMeasure4: String? = null,
    val strMeasure5: String? = null,
    val strMeasure6: String? = null,
    val strMeasure7: String? = null,
    val strMeasure8: String? = null,
    val strMeasure9: String? = null,
    val strMeasure10: String? = null,
    val strMeasure11: String? = null,
    val strMeasure12: String? = null,
    val strMeasure13: String? = null,
    val strMeasure14: String? = null,
    val strMeasure15: String? = null,
    val strImageSource: String? = null,
    val strImageAttribution: String? = null,
    val strCreativeCommonsConfirmed: String? = null,
    val dateModified: String? = null,
)

class MaListeFragment : Fragment(R.layout.fragment_liste) {
    fun api(listTxT: MutableList<String>, listURL: MutableList<String>) = runBlocking {
        // this: CoroutineScope
        launch { // launch a new coroutine and continue
            val client = HttpClient(CIO) {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                        prettyPrint = true
                        isLenient = true; ignoreUnknownKeys = true
                    })
                }
            }
            val response: Result =
                client.get("http://www.thecocktaildb.com/api/json/v1/1/random.php") {
                }
            response.drinks[0].strDrink?.let { listTxT.add(it) }
            response.drinks[0].strDrinkThumb?.let { listURL.add(it) }
            client.close()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listTxT = mutableListOf<String>()
        val listURL = mutableListOf<String>()
        var i = 0
        while (i < 20) {
            api(listTxT,listURL)
            i += 1;
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = NameAdapter(listTxT,listURL){
            //action au click du tableau
            findNavController().navigate(MaListeFragmentDirections.actionMaListeFragmentToAcceuil())
        }
    }
}