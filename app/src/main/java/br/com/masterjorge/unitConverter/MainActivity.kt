package br.com.masterjorge.unitConverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.masterjorge.unitConverter.presentation.length.Home
import br.com.masterjorge.unitConverter.presentation.length.LengthEvents
import br.com.masterjorge.unitConverter.presentation.length.ViewModelHome
import br.com.masterjorge.unitConverter.presentation.ui.theme.UnitConverterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold {paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        val viewModelHome = hiltViewModel<ViewModelHome>()
                        val stateLength = viewModelHome.stateLength
                        Home(
                            stateLengthState = stateLength,
                            onEvent = viewModelHome::onEvent,
                        )
                    }
                }
            }
        }
    }
}