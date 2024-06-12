package cl.eftec.app20240612.modelomut

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CategoriaMut {
    var nombre  by mutableStateOf<String?>(null)
    var descripcion  by mutableStateOf<String?>(null)
}