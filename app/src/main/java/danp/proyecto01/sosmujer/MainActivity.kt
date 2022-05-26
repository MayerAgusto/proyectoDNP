package danp.proyecto01.sosmujer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.platform.LocalContext
import danp.proyecto01.sosmujer.ui.theme.LoginJetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            LoginJetpackComposeTheme {
                val context = LocalContext.current
                val dataStore = UserDataSore(context)

                val userName = dataStore.getName.collectAsState(initial = "")
                val userDepartament = dataStore.getDepartament.collectAsState(initial = "")

                if(userName.value!! == "" && userDepartament.value!! == ""){
                    LoginScreen()
                }
                else{
                    SecondView()
                }
            }
        }
    }
}
