import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FilterScreenViewModelTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: FilterScreenViewModel

    @Before
    fun setUp() {
        viewModel = FilterScreenViewModel()
    }

    @Test
    fun test_initial_state_is_correct() {
        Assert.assertFalse(viewModel.isNameChecked)
        Assert.assertFalse(viewModel.isTypeChecked)
        Assert.assertFalse(viewModel.isSoilQualityChecked)
        Assert.assertFalse(viewModel.isWateringChecked)
        Assert.assertEquals(viewModel.sortingOption, "Synkende")
    }

    @Test
    fun test_update_name_check_state() {
        viewModel.updateNameChecked(true)
        Assert.assertTrue(viewModel.isNameChecked)
    }

    @Test
    fun test_update_type_check_state() {
        viewModel.updateTypeChecked(true)
        Assert.assertTrue(viewModel.isTypeChecked)
    }

    @Test
    fun test_update_soil_quality_check_state() {
        viewModel.updateSoilQualityChecked(true)
        Assert.assertTrue(viewModel.isSoilQualityChecked)
    }

    @Test
    fun test_update_watering_check_state() {
        viewModel.updateWateringChecked(true)
        Assert.assertTrue(viewModel.isWateringChecked)
    }

    @Test
    fun test_update_sorting_option() {
        val newOption = "Stigende"
        viewModel.updateSortingOption(newOption)
        Assert.assertEquals(viewModel.sortingOption, newOption)
    }
}
