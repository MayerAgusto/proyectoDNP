package dev.leonardom.loginjetpackcompose.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color





@Composable
fun AutoComplete(
    selectedItem: MutableState<String>
){
    var expanded by remember { mutableStateOf(false)}
    var provincias = "Amazonas, Ancash, Apurimac, Arequipa, Ayacucho, Cajamarca, Callao, Cusco, Huancavelica, Huanuco, Ica, Junín, La Libertad, Lambayeque, Lima, Loreto, Madre de Dios, Moquegua, Pasco, Piura, Puno, San Martín, Tacna, Tumbes, Ucayali"
    //var selectedItem by remember{mutableStateOf("")}
    val list = provincias.split(",").map { it.trim().toUpperCase() }
    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column() {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = selectedItem.value,
            enabled = false,
            onValueChange = {selectedItem.value = it},
            label = { Text(text = "Selecciona etu departamento")},
            trailingIcon = {
                Icon(icon, "",Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(),
        ) {
            list.forEach {
                    label ->
                DropdownMenuItem(onClick = {
                    selectedItem.value = label
                    expanded = false
                }) {
                    Text(text = label, color = Color.Black)
                }
            }

        }
    }


}