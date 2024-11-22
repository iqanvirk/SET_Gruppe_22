import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.*

@Composable
fun FilterScreen(navController: NavController) {
    val viewModel: FilterScreenViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorManager.Background)
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
                    tint = ColorManager.TextColor
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Filtre:", fontSize = 18.sp, color = ColorManager.TextColor)

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth()
        ) {
            item { FilterCheckbox(label = "Navn", checked = viewModel.isNameChecked, onCheckedChange = { viewModel.updateNameChecked(it) }) }
            item { FilterCheckbox(label = "Type", checked = viewModel.isTypeChecked, onCheckedChange = { viewModel.updateTypeChecked(it) }) }
            item { FilterCheckbox(label = "Jordkvalitet", checked = viewModel.isSoilQualityChecked, onCheckedChange = { viewModel.updateSoilQualityChecked(it) }) }
            item { FilterCheckbox(label = "Vanning", checked = viewModel.isWateringChecked, onCheckedChange = { viewModel.updateWateringChecked(it) }) }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Sortering:", fontSize = 16.sp, color = ColorManager.TextColor)
        SortingDropdownMenu(
            options = viewModel.sortingOptions,
            selectedOption = viewModel.sortingOption,
            onOptionSelected = { viewModel.updateSortingOption(it) }
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
            colors = CheckboxDefaults.colors(
                checkedColor = ColorManager.TextColor,
                uncheckedColor = Color(0xFF757575),
                checkmarkColor = ColorManager.DarkBackground
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(label, color = ColorManager.TextColor)
    }
}

@Composable
fun SortingDropdownMenu(options: List<String>, selectedOption: String, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(onClick = { expanded = true }) {
            Text(selectedOption, color = ColorManager.TextColor)
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = ColorManager.TextColor)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(ColorManager.DarkBackground)
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    text = {
                        Text(
                            text = option,
                            color = ColorManager.TextColor
                        )
                    },
                    modifier = Modifier
                        .background(ColorManager.DarkBackground)
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




