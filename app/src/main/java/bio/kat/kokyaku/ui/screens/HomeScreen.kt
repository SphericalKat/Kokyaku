package bio.kat.kokyaku.ui.screens

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import bio.kat.kokyaku.ui.navigation.BottomNavItem
import bio.kat.kokyaku.ui.theme.KokyakuTheme
import com.deliveryhero.whetstone.app.ApplicationScope
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.foundation.CircuitContent
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.Screen
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.parcelize.Parcelize

@Parcelize
object HomeScreen : Screen {
    data class State(
        val navItems: ImmutableList<BottomNavItem> =
            persistentListOf(BottomNavItem.Search, BottomNavItem.History),
        val selectedIndex: Int = 0,
        val eventSink: (Event) -> Unit,
    ): CircuitUiState

    sealed interface Event : CircuitUiEvent {
        class ClickNavItem(val index: Int) : Event
    }
}

@CircuitInject(screen = HomeScreen::class, scope = ApplicationScope::class)
@Composable
fun HomePresenter(navigator: Navigator): HomeScreen.State {
    var selectedIndex by remember { mutableStateOf(0) }

    return HomeScreen.State(selectedIndex = selectedIndex) { event ->
        when (event) {
            is HomeScreen.Event.ClickNavItem -> {
                selectedIndex = event.index
            }
        }
    }
}

@CircuitInject(screen = HomeScreen::class, scope = ApplicationScope::class)
@Composable
fun HomeContent(state: HomeScreen.State, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxWidth(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        containerColor = Color.Transparent,
        bottomBar = {
            KokyakuTheme {
                BottomNavBar(selectedIndex = state.selectedIndex, onSelectedIndex = { index ->
                    state.eventSink(HomeScreen.Event.ClickNavItem(index))
                })
            }
        }
    ) { paddingValues ->
        val screen = state.navItems[state.selectedIndex].screen
        CircuitContent(
            screen = screen,
            modifier = Modifier.padding(paddingValues),
            // TODO: add later
//            onNavEvent = { event -> state }
        )
    }
}

@Composable
private fun BottomNavBar(selectedIndex: Int, onSelectedIndex: (Int) -> Unit) {
    val items = remember { listOf(BottomNavItem.Search, BottomNavItem.History) }
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                alwaysShowLabel = true,
                selected = selectedIndex == index,
                onClick = { onSelectedIndex(index) }
            )
        }
    }
}
