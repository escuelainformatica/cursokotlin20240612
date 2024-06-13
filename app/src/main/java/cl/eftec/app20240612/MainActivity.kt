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
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cl.eftec.app20240612.composable.ListaDesplegable
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
                            var seleccion by remember { mutableStateOf(0) }

                            Button(onClick = {
                                principalVM.scope!!.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }) {
                                Text("Abrir slider")
                            }
                            ListaDesplegable(principalVM.autorVM.autores,indexActual=2
                                    ,modificarSeleccion={seleccion=it}
                            )
                            Text("el valor seleccionado es ${seleccion}")
                            Navegacion(principalVM = principalVM)
                        }
                    }
                }
            }
        }
    }
}
