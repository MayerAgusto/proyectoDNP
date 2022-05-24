package danp.proyecto01.sosmujer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Museum
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import danp.proyecto01.sosmujer.ui.theme.components.BigButton
import kotlin.system.exitProcess

@Composable
fun SecondView() {

    val context = LocalContext.current
    val dataStore = UserDataSore(context)
    val departamento =dataStore.getDepartament.collectAsState(initial = "").value
    val name = dataStore.getName.collectAsState(initial = "").value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.error)
            .padding(20.dp)
    )
    {
        var nextView:Boolean by remember { mutableStateOf(true)}
        if(nextView) {
            Column(
                    horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    text="BIENVENIDA\n${name?.uppercase()} ",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    style = MaterialTheme.typography.h4.copy(
                        color = Color.White,
                    ),
                    textAlign = TextAlign.Start
                )

                Text(
                    text="Recuerde:\n" + "Si quiere realizar una llamada de emergencia a la linea #100 solo pulse el botón a continuación:",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    style = MaterialTheme.typography.h5.copy(
                        color = Color.White,
                    ),
                    textAlign = TextAlign.Start
                )

                BigButton(text = "Llamar a la Línea Directa 100")

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                )
                {
                    Button(
                        onClick = {
                            exitProcess(0)
                        },
                        modifier = Modifier.weight(15.0f)
                    )
                    {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        {
                            Icon(
                                modifier = Modifier.size(50.dp),
                                imageVector = Icons.Default.ExitToApp,
                                contentDescription = "Icono boton",
                                tint = Color.White
                            )
                            Text("\nCerrar Sesion ",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Spacer(Modifier.weight(1.0f))

                    Button(
                        onClick = {
                            nextView=false
                        },
                        modifier = Modifier.weight(15.0f)
                    )
                    {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        {
                            Icon(
                                modifier = Modifier.size(50.dp),
                                imageVector = Icons.Default.Museum,
                                contentDescription = "Icono boton",
                                tint = Color.White
                            )
                            Text("CEM de mi departamento",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

            }
        }

        else{
             CEMList(departament = departamento)
        }
    }
}