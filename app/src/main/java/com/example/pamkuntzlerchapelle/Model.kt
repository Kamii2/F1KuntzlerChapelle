package com.example.pamkuntzlerchapelle
import retrofit2.Call
import com.google.gson.annotations.SerializedName

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