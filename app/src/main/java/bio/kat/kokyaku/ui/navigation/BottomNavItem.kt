package bio.kat.kokyaku.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import bio.kat.kokyaku.ui.screens.AboutScreen
import com.slack.circuit.runtime.Screen

private const val SEARCH_SCREEN_NAME = "Search"
private const val HISTORY_SCREEN_NAME = "History"

sealed class BottomNavItem(val title: String, val icon: ImageVector) {
    abstract val screen: Screen

    object Search: BottomNavItem(SEARCH_SCREEN_NAME, Icons.Filled.Search) {
        override val screen: Screen
            get() = AboutScreen
    }

    object History: BottomNavItem(HISTORY_SCREEN_NAME, Icons.Filled.History) {
        override val screen: Screen
            get() = AboutScreen
    }
}