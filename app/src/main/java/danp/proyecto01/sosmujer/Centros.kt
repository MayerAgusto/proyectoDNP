package danp.proyecto01.sosmujer


import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.toObject

data class Centros(
    var id: String? = null,
    var coordinador: String? = null,
    var departamento: String? = null,
    var direccion: String? = null,
    var distrito: String? = null,
    var latitud: String? = null,
    var longitud: String? = null,
    var nombre: String? = null,
    var provincia: String? = null,
    var telefono: String? = null,
    var tipo: String? = null,
){
 companion object {
    fun toObject(doc: DocumentSnapshot): Centros? {
        val item = doc.toObject<Centros>()
        item?.id = doc.id
        return item
    }
}
}

