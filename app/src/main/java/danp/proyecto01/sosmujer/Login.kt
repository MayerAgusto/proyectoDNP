package danp.proyecto01.sosmujer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import danp.proyecto01.sosmujer.ui.theme.components.AutoComplete
import danp.proyecto01.sosmujer.ui.theme.components.CustomTextfield
import danp.proyecto01.sosmujer.ui.theme.components.RoundedButton
import kotlinx.coroutines.launch

@Composable
fun LoginScreen() {
    val nameValue = rememberSaveable{ mutableStateOf("")}
    var selectedItem = rememberSaveable{mutableStateOf("")}
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = UserDataSore(context)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ){
        Image(painter = painterResource(id = R.drawable.looge), contentDescription = "Image Logo",
        contentScale = ContentScale.Inside)

        Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter){
           ConstraintLayout{
               val (surface, fab) = createRefs()

               Surface(
                   modifier = Modifier
                       .fillMaxWidth()
                       .height(400.dp)
                       .constrainAs(surface) {
                           bottom.linkTo(parent.bottom)
                       },
                   color = MaterialTheme.colors.error,
                   shape = RoundedCornerShape(
                       topStartPercent = 8,
                       topEndPercent = 8
                   )
               ) {
                   Column(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(16.dp),
                       verticalArrangement = Arrangement.SpaceEvenly
                   ) {
                       Text(text = "Bienvenido",
                           style = MaterialTheme.typography.h4.copy(
                               fontWeight = FontWeight.Medium
                           )
                       )
                       Text(text = "Inicio de sesión",
                           style = MaterialTheme.typography.h4.copy(
                               color = MaterialTheme.colors.primary
                           )
                       )
                       Column(
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(horizontal = 16.dp),
                           horizontalAlignment = Alignment.CenterHorizontally,
                           verticalArrangement = Arrangement.spacedBy(8.dp)
                       ) {
                           CustomTextfield(
                               textFieldValue = nameValue,
                               textLabel = "Nombre" ,
                               keyboardType = KeyboardType.Text,
                               keyboardActions = KeyboardActions(
                                   onNext = {
                                       focusManager.moveFocus(FocusDirection.Down)
                                   }
                               ) ,
                               imeAction = ImeAction.Next
                           )
                           AutoComplete(selectedItem = selectedItem)

                       }

                       Column(
                           modifier = Modifier.fillMaxWidth(),
                           horizontalAlignment = Alignment.CenterHorizontally,
                           verticalArrangement = Arrangement.spacedBy(8.dp)
                       ){
                           RoundedButton(text = "Inicio", displayProgressBar = false,
                           onClick = {
                               scope.launch {
                                   if(nameValue.value!=="" && selectedItem.value!==""){
                                   dataStore.saveName(nameValue.value)
                                   dataStore.saveDepartament(selectedItem.value)
                                   }
                               }
                           })
                       }
                   }
               }
               FloatingActionButton(
                   modifier = Modifier
                       .size(72.dp)
                       .constrainAs(fab) {
                           top.linkTo(surface.top, margin = (-36).dp)
                           end.linkTo(surface.end, margin = 36.dp)
                       },
                   backgroundColor = MaterialTheme.colors.primary,
                   onClick = { /*TODO*/ }) {
                   Icon(
                       modifier = Modifier.size(42.dp),
                       imageVector = Icons.Default.ArrowForward,
                       contentDescription = "Icono boton",
                       tint = Color.White
                   )
               }
           }
        }

    }
}