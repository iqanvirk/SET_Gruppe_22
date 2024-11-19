import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FilterScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    var isNameChecked by remember { mutableStateOf(false) }
    var isTypeChecked by remember { mutableStateOf(false) }
    var isSoilQualityChecked by remember { mutableStateOf(false) }
    var isWateringChecked by remember { mutableStateOf(false) }
    var sortingOption by remember { mutableStateOf("Synkende") }
    val sortingOptions = listOf("Synkende", "Stigende")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F1F1F))
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close button",
                    tint = Color(0xFFD2D2D2)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Filtre:", fontSize = 18.sp, color = Color(0xFFD2D2D2))

        Spacer(modifier = Modifier.height(8.dp))


        FilterCheckbox(label = "Navn", checked = isNameChecked, onCheckedChange = { isNameChecked = it })
        FilterCheckbox(label = "Type", checked = isTypeChecked, onCheckedChange = { isTypeChecked = it })
        FilterCheckbox(label = "Jordkvalitet", checked = isSoilQualityChecked, onCheckedChange = { isSoilQualityChecked = it })
        FilterCheckbox(label = "Vanning", checked = isWateringChecked, onCheckedChange = { isWateringChecked = it })

        Spacer(modifier = Modifier.height(16.dp))


        Text("Sortering:", fontSize = 16.sp, color = Color(0xFFD2D2D2))
        SortingDropdownMenu(
            options = sortingOptions,
            selectedOption = sortingOption,
            onOptionSelected = { sortingOption = it }
        )
    }
}

@Composable
fun FilterCheckbox(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(checkmarkColor = Color(0xFFD2D2D2))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(label, color = Color(0xFFD2D2D2))
    }
}

@Composable
fun SortingDropdownMenu(options: List<String>, selectedOption: String, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(onClick = { expanded = true }) {
            Text(selectedOption, color = Color(0xFFD2D2D2))
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = Color(0xFFD2D2D2))
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    text = { Text(option) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview() {
    FilterScreen(navController = NavController(LocalContext.current))
}




