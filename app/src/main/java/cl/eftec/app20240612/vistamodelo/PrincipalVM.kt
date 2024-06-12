package cl.eftec.app20240612.vistamodelo

import androidx.compose.material3.DrawerState
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PrincipalVM {
    // para mostrar y ocultar el menu lateral
    var drawerState: DrawerState?=null

    // para pantallas que requieren los autores
    val autorVM=AutorVistaModelo()
    // para pantallas que requieren las categorias
    val categoriaVM=CategoriaVistaModelo()
    // para pantallas que requieren los libros
    val libroVM=LibroVistaModelo()
    // tareas asincronicas
    var scope: CoroutineScope?=null
    // para mostrar el snackbar
    var snackBar: SnackbarHostState?=null
    // para navegar entre paginas
    var navController: NavHostController?=null

    /**
     * Cierra el menu slider
     */
    fun CerrarMenu() {
        scope!!.launch {
            drawerState!!.apply {
                close()
            }
        }
    }
}