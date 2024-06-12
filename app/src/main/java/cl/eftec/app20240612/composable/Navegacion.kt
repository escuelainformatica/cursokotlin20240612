package cl.eftec.app20240612.composable

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.eftec.app20240612.composable.paginas.AutorFormularioPagina
import cl.eftec.app20240612.composable.paginas.AutorListarPagina
import cl.eftec.app20240612.composable.paginas.CategoriaFormularioPagina
import cl.eftec.app20240612.composable.paginas.CategoriaListarPagina
import cl.eftec.app20240612.composable.paginas.LibroFormularioPagina
import cl.eftec.app20240612.composable.paginas.LibroListarPagina
import cl.eftec.app20240612.vistamodelo.PrincipalVM

@Composable
fun Navegacion(principalVM: PrincipalVM) {
    val navController = rememberNavController()
    principalVM.navController=navController
    NavHost(navController = navController, startDestination = "navlibrolistar") {
        composable("navlibrolistar") { LibroListarPagina(principalVM) }
        composable("navlibroformulario") { LibroFormularioPagina(principalVM) }
        composable("navcategorialistar") { CategoriaListarPagina(principalVM) }
        composable("navcategoriaformulario") { CategoriaFormularioPagina(principalVM) }
        composable("navautorlistar") { AutorListarPagina(principalVM) }
        composable("navautorformulario") { AutorFormularioPagina(principalVM) }

    }
}