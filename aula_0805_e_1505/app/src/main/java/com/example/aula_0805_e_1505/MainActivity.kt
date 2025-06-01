import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aula_0805_e_1505.LoadingBar
import com.example.aula_0805_e_1505.MainViewModel
import com.example.aula_0805_e_1505.MusicaCard
import com.example.aula_0805_e_1505.TokenStore
import com.example.aula_0805_e_1505.appModule
import com.example.aula_0805_e_1505.ui.theme.Aula_0805_e_1505Theme
import org.koin.android.ext.koin.androidContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        startKoin {
            modules(appModule)
            androidContext(this@MainActivity)
        }
        setContent {
            Aula_0805_e_1505Theme {
                App(vm = koinViewModel<MainViewModel>())
            }
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    Aula_0805_e_1505Theme {
        App(vm = viewModel<MainViewModel>())
    }
}

@Composable
fun App(vm: MainViewModel) {
    val context = LocalContext.current
    LaunchedEffect(true) {
        TokenStore.obterToken(context).collect { token ->
            token?.let {
                vm.loadMusicas(it)
            }
            /*
            if (token != null) {
                vm.loadMusicas(token)
            }
             */
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        if (vm.isLoading) {
            LoadingBar()
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                item {
                    Button(onClick = { vm.login(context) }) {
                        Text("Fazer Login")
                    }
                }
                items(vm.musicas) { musica ->
                    MusicaCard(musica)
                }
            }
        }
    }
}