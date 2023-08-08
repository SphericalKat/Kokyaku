package bio.kat.kokyaku.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import bio.kat.kokyaku.ui.screens.HomeScreen
import bio.kat.kokyaku.ui.theme.KokyakuTheme
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.NavigableCircuitContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable()
fun KokyakuApp() {
//    val backstack = rememberSaveableBackStack { push(HomeScreen) }

    KokyakuTheme(dynamicColor = true) {
        // A surface container using the 'background' color from the theme
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    println("get")
                }) {

                }
            },
            bottomBar = {
//                NavigableCircuitContent(navigator = ) {
//
//                }
            }
        ) {
            Row {
                Text(text = "Hello, World!")
            }
        }
    }
}