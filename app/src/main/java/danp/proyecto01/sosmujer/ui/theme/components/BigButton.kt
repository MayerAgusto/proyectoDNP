package danp.proyecto01.sosmujer.ui.theme.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BigButton(
    text:String
){
    val context = LocalContext.current
    Button(
        onClick = {
            val numero ="100".trim()
            val i = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ Uri.encode(numero)))
            context.startActivity(i)
        },

        modifier= Modifier
            .size(270.dp)
            .padding(15.dp),
        shape = CircleShape,
        border = BorderStroke(4.dp, Color.White)
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)
        )
        {
            Icon(
                modifier = Modifier.size(120.dp),
                imageVector = Icons.Default.Phone,
                contentDescription = "Icono boton",
                tint = Color.White
            )
            Text(text=text, fontSize = 20.sp, textAlign = TextAlign.Center)
        }
    }
}