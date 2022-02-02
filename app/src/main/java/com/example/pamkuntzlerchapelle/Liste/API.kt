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

class API {
    suspend fun apicall():List<Cocktail>
    // this: CoroutineScope
    { // launch a new coroutine and continu
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
        for (i in 1..15) {
            var response: Result =
                client.get("http://www.thecocktaildb.com/api/json/v1/1/random.php") {
                }
            val name= response.drinks[0].strDrink
            val url = response.drinks[0].strDrinkThumb
            val instruction = response.drinks[0].strInstructions
            if(name != null && url != null && instruction != null) {
                cocktails.add(Cocktail(name, url, instruction))
            }
        }
        client.close()
        return cocktails.toList()
    }
}