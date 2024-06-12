package cl.eftec.app20240612.modelomut

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class LibroMut {
    var title  by mutableStateOf<String?>(null)
    var autor  by mutableStateOf<AutorMut?>(null)
    var categoria  by mutableStateOf<CategoriaMut?>(null)
}