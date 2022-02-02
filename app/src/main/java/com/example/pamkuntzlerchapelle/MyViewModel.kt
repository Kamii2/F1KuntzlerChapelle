import android.os.Debug
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamkuntzlerchapelle.Liste.API
import kotlinx.coroutines.launch

data class Cocktail(var name: String, var URL: String)

class MyViewModel : ViewModel() {
    val my_api = API()
    private val cocktails: MutableLiveData<List<Cocktail>> by lazy {
        MutableLiveData<List<Cocktail>>().also {
            loadCocktails(it)
        }
    }

    fun getCocktails(): LiveData<List<Cocktail>> {
        return cocktails
    }

    private fun loadCocktails(livedata : MutableLiveData<List<Cocktail>> ) {
        viewModelScope.launch{ livedata.value = my_api.apicall()}
        // Do an asynchronous operation to fetch users.
    }
}