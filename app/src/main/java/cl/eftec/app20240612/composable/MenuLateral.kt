package cl.eftec.app20240612.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.eftec.app20240612.vistamodelo.PrincipalVM
import kotlinx.coroutines.launch

@Composable
fun MenuLateral(principalVM: PrincipalVM) {
    Text("Drawer title", modifier = Modifier.padding(16.dp))
    Divider()
    NavigationDrawerItem(
        label = { Text(text = "Listar Autores") },
        selected = false,
        onClick = {
            principalVM.CerrarMenu()
            principalVM.navController!!.navigate("navautorlistar")
        }
    )


    NavigationDrawerItem(
        label = { Text(text = "Agregar Autor") },
        selected = false,
        onClick = {
            principalVM.CerrarMenu()
            principalVM.navController!!.navigate("navautorformulario")
        }
    )
    NavigationDrawerItem(
        label = { Text(text = "Listar Categorias") },
        selected = false,
        onClick = {
            principalVM.CerrarMenu()
            principalVM.navController!!.navigate("navcategorialistar")
        }
    )
    NavigationDrawerItem(
        label = { Text(text = "Agregar Categoria") },
        selected = false,
        onClick = {
            principalVM.CerrarMenu()
            principalVM.navController!!.navigate("navcategoriaformulario")
        }
    )
    NavigationDrawerItem(
        label = { Text(text = "Listar Libro") },
        selected = false,
        onClick = {
            principalVM.CerrarMenu()
            principalVM.navController!!.navigate("navlibrolistar")
        }
    )
    NavigationDrawerItem(
        label = { Text(text = "Agregar libro") },
        selected = false,
        onClick = {
            principalVM.CerrarMenu()
            principalVM.navController!!.navigate("navlibroformulario")
        }
    )
    // ...other drawer items
}