package cl.eftec.app20240612.vistamodelo

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import cl.eftec.app20240612.modelomut.CategoriaMut
import cl.eftec.app20240612.modelomut.LibroMut
import kotlinx.coroutines.CoroutineScope

class LibroVistaModelo {
    // para el formulario
    val autor  by mutableStateOf<LibroMut?>(null)
    // para los listados
    val autores = mutableStateListOf<LibroMut>()

}