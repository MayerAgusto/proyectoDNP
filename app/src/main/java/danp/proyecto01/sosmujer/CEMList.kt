package danp.proyecto01.sosmujer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.items
import danp.proyecto01.sosmujer.ui.theme.components.CardDepartamento


@Composable
fun CEMList(viewModel: CemViewModel) {
    val centroResource by viewModel.fetchPosts().collectAsState(initial = Resource.loading(null))
    val centrodata = centroResource.data ?: emptyList()

    if (centroResource.status == Status.ERROR) {
        Text("Error: ${centroResource.message}")
    }
    else if (centroResource.status == Status.LOADING) {
        Text("Loading ....")
    }
    else {
        LazyColumn {
            items(centrodata) { data ->
                if (data != null) {
                    CardDepartamento(data)
                }
            }
        }
    }
}

