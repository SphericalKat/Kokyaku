package bio.kat.kokyaku.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bio.kat.kokyaku.R
import bio.kat.kokyaku.ui.theme.KokyakuTheme
import com.deliveryhero.whetstone.app.ApplicationScope
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
object AboutScreen : Screen {
    object State : CircuitUiState
}

@CircuitInject(screen = AboutScreen::class, scope = ApplicationScope::class)
@Composable
fun AboutPresenter(): AboutScreen.State = AboutScreen.State

@CircuitInject(screen = AboutScreen::class, scope = ApplicationScope::class)
@Composable
fun About(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize().padding(16.dp),
        content = { padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(96.dp),
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Kokyaku icon",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = stringResource(id = R.string.about_screen), textAlign = TextAlign.Justify)
            }
        }
    )
}

@Preview
@Composable
private fun AboutPreview() {
    KokyakuTheme { About() }
}