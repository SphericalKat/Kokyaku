package bio.kat.kokyaku.ui.screens

import androidx.compose.runtime.Composable
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
object HomeScreen : Screen {
    data class HomeState(
        val eventSink: (HomeEvent) -> Unit
    )

    sealed interface HomeEvent : CircuitUiEvent {
        object Refresh : HomeEvent
    }
}