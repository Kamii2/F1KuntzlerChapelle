import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamkuntzlerchapelle.Liste.API
import kotlinx.coroutines.launch

/*
    Definition de la classe Cocktail.
 */
data class Cocktail(var name: String, var URL: String, var instruction:String)

/*
    Gestion de la destruction des fragments (les donnees sont sauvegardees dans le ViewModel).
 */
class MyViewModel : ViewModel() {
    val myApi = API()
    private val cocktails: MutableLiveData<List<Cocktail>> by lazy {
        MutableLiveData<List<Cocktail>>().also {
            loadCocktails(it)
        }
    }

    fun getCocktails(): LiveData<List<Cocktail>> {
        return cocktails
    }

    private fun loadCocktails(livedata : MutableLiveData<List<Cocktail>> ) {
        viewModelScope.launch{ livedata.value = myApi.apiCall()}
    }
}