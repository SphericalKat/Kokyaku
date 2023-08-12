package bio.kat.kokyaku

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import bio.kat.kokyaku.ui.screens.HomeScreen
import bio.kat.kokyaku.ui.theme.KokyakuTheme
import com.deliveryhero.whetstone.Whetstone
import com.deliveryhero.whetstone.activity.ContributesActivityInjector
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.push
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.slack.circuit.runtime.Screen
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import javax.inject.Inject


@ContributesActivityInjector
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var circuit: Circuit

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        Whetstone.inject(this)
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val backStack: ImmutableList<Screen> = persistentListOf(HomeScreen)

        setContent {
            KokyakuTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val backstack =
                        rememberSaveableBackStack { backStack.forEach { screen -> push(screen) } }
                    val circuitNavigator = rememberCircuitNavigator(backstack)
                    val navigator = remember(circuitNavigator) { circuitNavigator }
                    CompositionLocalProvider {
                        CircuitCompositionLocals(circuit) {
                            NavigableCircuitContent(navigator, backstack)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KokyakuTheme {
        Greeting("Android")
    }
}