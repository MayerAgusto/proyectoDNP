package dev.leonardom.loginjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import dev.leonardom.loginjetpackcompose.ui.theme.LoginJetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            LoginJetpackComposeTheme {
                val context = LocalContext.current
                val dataStore = UserDataSore(context)

                val userName = dataStore.getName.collectAsState(initial = "")
                val userDepartament = dataStore.getDepartament.collectAsState(initial = "")
                if(userName.value!! == "no" && userDepartament.value!! == "no"){
                    LoginScreen()
                }
                else{
                    SecondView()
                }

            }
        }
    }
}