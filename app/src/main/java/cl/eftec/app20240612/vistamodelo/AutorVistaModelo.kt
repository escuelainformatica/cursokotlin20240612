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

    constructor() {
        var autor1=AutorMut()
        autor1.nombre="nombre-0"
        autores.add(autor1)
        autor1=AutorMut()
        autor1.nombre="nombre-1"
        autores.add(autor1)
        autor1=AutorMut()
        autor1.nombre="nombre-2"
        autores.add(autor1)
        autor1=AutorMut()
        autor1.nombre="nombre-3"
        autores.add(autor1)
    }


    fun AgregarAutor() {
        var autorNuevo=AutorMut()
        autorNuevo.nombre=autor.nombre
        autorNuevo.direccion=autor.direccion
        autores.add(autorNuevo)
    }

}