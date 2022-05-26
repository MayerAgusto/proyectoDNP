package danp.proyecto01.sosmujer

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow


class CemViewModel(departamento : String?) : ViewModel() {
    private val db = Firebase.firestore
    private val depa = departamento

    fun fetchPosts() = callbackFlow {
        val collection = db.collection("centros_emergencia_mujer")

        val snapshotListener = collection.whereEqualTo("departamento", depa).addSnapshotListener{ value, error ->

            val response = if (error == null && value != null) {
                val data = value.documents.map { doc ->
                    Centros.toObject(doc)
                }
                Resource.success(data)
            } else {
                Resource.error(error.toString(), null)
            }

            this.trySend(response).isSuccess
        }

        awaitClose() {
            snapshotListener.remove()
        }
    }
}
