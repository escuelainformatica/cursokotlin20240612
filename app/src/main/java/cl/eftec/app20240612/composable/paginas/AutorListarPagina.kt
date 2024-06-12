package cl.eftec.app20240612.composable.paginas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cl.eftec.app20240612.vistamodelo.PrincipalVM

@Composable
fun AutorListarPagina(principalVM: PrincipalVM) {
    Column {
        Text("Listado de autores")
        for(autor in principalVM.autorVM.autores) {
            Text("Autor: ${autor.nombre}")
        }
    }
}