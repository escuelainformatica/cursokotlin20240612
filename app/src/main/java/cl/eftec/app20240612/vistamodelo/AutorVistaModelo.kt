package cl.eftec.app20240612.vistamodelo

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import cl.eftec.app20240612.modelomut.AutorMut
import kotlinx.coroutines.CoroutineScope

class AutorVistaModelo {
    // para el formulario
    val autor  by mutableStateOf(AutorMut())
    // para los listados
    val autores = mutableStateListOf<AutorMut>()

    fun AgregarAutor() {
        var autorNuevo=AutorMut()
        autorNuevo.nombre=autor.nombre
        autorNuevo.direccion=autor.direccion
        autores.add(autorNuevo)
    }

}