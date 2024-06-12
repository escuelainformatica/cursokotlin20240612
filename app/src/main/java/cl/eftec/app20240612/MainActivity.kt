package cl.eftec.app20240612

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.eftec.app20240612.composable.MenuLateral
import cl.eftec.app20240612.composable.Navegacion
import cl.eftec.app20240612.ui.theme.App20240612Theme
import cl.eftec.app20240612.vistamodelo.PrincipalVM
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val principalVM=PrincipalVM()

        setContent {
            App20240612Theme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                principalVM.scope = rememberCoroutineScope()
                principalVM.drawerState=drawerState
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    gesturesEnabled = true,
                    drawerContent = {
                        ModalDrawerSheet(
                            modifier = Modifier.fillMaxWidth(0.5f),
                        ) {
                            MenuLateral(principalVM = principalVM)
                        }
                    }
                ) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Column(
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            Button(onClick = {
                                principalVM.scope!!.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }) {
                                Text("Abrir slider")
                            }
                            Navegacion(principalVM = principalVM)
                        }
                    }
                }
            }
        }
    }
}
