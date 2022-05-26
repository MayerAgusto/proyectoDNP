package danp.proyecto01.sosmujer.ui.theme.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import danp.proyecto01.sosmujer.Centros
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
@Composable
fun CardDepartamento(cn: Centros){
    Surface(shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp),
        ) {
            val modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
            val painter = rememberAsyncImagePainter(model = "https://res.cloudinary.com/dk2g5rw5w/image/upload/v1653502036/CEM_PERU/CEM_Lambayeque_e5orwh.jpg")
            val estado = painter.state
            Image(painter = painter,
                contentDescription =null,
                modifier = modifier,
                contentScale = ContentScale.Crop
            )
            if(estado is AsyncImagePainter.State.Loading){
                CircularProgressIndicator()
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                Column() {
                    Text(text = cn.nombre.toString() + "\n" + cn.provincia.toString()+"\n",color = Color.Black, style = MaterialTheme.typography.h5)
                    Text( text ="Direccion : "+cn.direccion.toString()+"\n"+ "Coordinador : "+cn.coordinador.toString(),color = Color.Gray,style = MaterialTheme.typography.h6)

                }
            }

        }
    }
}
