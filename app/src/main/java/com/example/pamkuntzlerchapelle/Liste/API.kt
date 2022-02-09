package com.example.pamkuntzlerchapelle.Liste

import Cocktail
import androidx.lifecycle.MutableLiveData
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.*

val nbCocktails = 15

class API {
    /*
        Fonction d'appel a la coroutine pour les appels API.
     */
    suspend fun apiCall():List<Cocktail>
    {
        var cocktails = mutableListOf<Cocktail>()
        val client = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }

        /*
            On fait la requete 15 fois pour recuperer nos 15 cocktails.
         */
        for (i in 1..nbCocktails) {
            var response: Result =
                client.get("http://www.thecocktaildb.com/api/json/v1/1/random.php") {
                }
            val name= response.drinks[0].strDrink
            val url = response.drinks[0].strDrinkThumb
            val instruction = response.drinks[0].strInstructions

            /*
                Si le cocktail est pas vide (pas d'erreur dans le JSON) on l'ajoute a notre liste.
             */
            if(name != null && url != null && instruction != null) {
                cocktails.add(Cocktail(name, url, instruction))
            }
        }
        client.close()
        return cocktails.toList()
    }
}