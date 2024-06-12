package cl.eftec.app20240612.composable.paginas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import cl.eftec.app20240612.elvis
import cl.eftec.app20240612.vistamodelo.PrincipalVM

@Composable
fun AutorFormularioPagina(principalVM: PrincipalVM) {
    Column {
        TextField(value = elvis(principalVM.autorVM.autor.nombre), onValueChange = {principalVM.autorVM.autor.nombre=it} )
        TextField(value = elvis(principalVM.autorVM.autor.direccion), onValueChange = {principalVM.autorVM.autor.direccion=it} )
        ElevatedButton(onClick = {
            principalVM.autorVM.AgregarAutor()
            principalVM.autorVM.autor.nombre=""
            principalVM.autorVM.autor.direccion=""
            principalVM.navController!!.popBackStack()
        }) {
            Text("Agregar")
        }
    }

}