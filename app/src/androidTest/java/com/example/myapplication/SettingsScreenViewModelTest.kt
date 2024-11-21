import android.content.ContextWrapper
import com.example.myapplication.ui.screens.settings.SettingsScreenViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SettingsScreenViewModelTest {

    private lateinit var viewModel: SettingsScreenViewModel
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setup() {
        viewModel = SettingsScreenViewModel()
    }

    @Test
    fun darkModeTest() = testScope.runTest {
        assertEquals(false, viewModel.isDarkMode.value)
        viewModel.darkMode1()
        assertEquals(true, viewModel.isDarkMode.value)
        viewModel.darkMode1()
        assertEquals(false, viewModel.isDarkMode.value)
    }

    @Test
    fun searchTest() = testScope.runTest {
        val newText = "New Search Text"
        viewModel.updateSearchText(newText)
        assertEquals(newText, viewModel.searchText.value)
    }

    @Test
    fun logoutTest() = testScope.runTest {
        val mockContext = ContextWrapper(null)  // Null is fine for testing purposes
        viewModel.logout(mockContext)
    }
}