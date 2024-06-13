package cl.eftec.app20240612.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cl.eftec.app20240612.elvis
import cl.eftec.app20240612.modelomut.AutorMut


@Composable
fun ListaDesplegable(
    autores: SnapshotStateList<AutorMut>,
    modificarSeleccion: (seleccion: Int) -> Unit,
    indexActual: Int
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(indexActual) }
    modificarSeleccion(selectedIndex)
    Box(modifier = Modifier.height(20.dp)) {
        Text(elvis(autores[selectedIndex].nombre),modifier = Modifier.fillMaxWidth().clickable(onClick = { expanded = true }).background(
            Color.Gray))
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth().background(
                Color.Red)
        ) {
            autores.forEachIndexed { index, s ->
                ListaDesplegableItem(elvis(s.nombre),onClick={
                    selectedIndex=index; expanded=false
                    modificarSeleccion(selectedIndex)
                })
            }
        }
    }
}
@Composable
fun ListaDesplegableItem(s: String, onClick: () -> Unit) {
    Text(s, modifier = Modifier.clickable { onClick() })
}


