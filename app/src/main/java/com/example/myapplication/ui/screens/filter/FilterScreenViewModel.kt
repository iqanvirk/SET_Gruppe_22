import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class FilterScreenViewModel : ViewModel() {
    var isNameChecked by mutableStateOf(false)
    var isTypeChecked by mutableStateOf(false)
    var isSoilQualityChecked by mutableStateOf(false)
    var isWateringChecked by mutableStateOf(false)
    var sortingOption by mutableStateOf("Synkende")
    val sortingOptions = listOf("Synkende", "Stigende")

    fun updateNameChecked(checked: Boolean) {
        isNameChecked = checked
    }

    fun updateTypeChecked(checked: Boolean) {
        isTypeChecked = checked
    }

    fun updateSoilQualityChecked(checked: Boolean) {
        isSoilQualityChecked = checked
    }

    fun updateWateringChecked(checked: Boolean) {
        isWateringChecked = checked
    }

    fun updateSortingOption(option: String) {
        sortingOption = option
    }
}
