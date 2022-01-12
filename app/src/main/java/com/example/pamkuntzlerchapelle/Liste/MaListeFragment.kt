package com.example.pamkuntzlerchapelle.Liste

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamkuntzlerchapelle.R
import com.google.gson.annotations.SerializedName

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Keep
@Serializable
data class Result(val data: Drinks)
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
    fun api() = runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            val client = HttpClient(CIO){
                install(JsonFeature){
                    serializer = KotlinxSerializer(kotlinx.serialization.json.Json { prettyPrint = true
                        isLenient = true  })
                }
            }
            val response: HttpResponse = client.request("http://www.thecocktaildb.com/api/json/v1/1/random.php"){
                contentType(ContentType.Application.Json)
                body = Result(Drinks(null))
            }
            Log.d("Json",response.readText())
            client.close()
        }


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        api()
        val initial = listOf("PinaColada", "Margarita", "Jus", "Puré", "J AI","PLus", "IDEE","MERDE")
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = NameAdapter(initial)
        Log.d("MaListe", "listSize ${initial.count()}")
    }
}