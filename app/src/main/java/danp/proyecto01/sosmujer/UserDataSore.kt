package danp.proyecto01.sosmujer

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserDataSore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userEmail")
        val USER_NAME_KEY = stringPreferencesKey("user_name")
        val USER_DEPARTAMENT_KEY = stringPreferencesKey("user_departament")
    }

    //get the saved email
    val getName: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_NAME_KEY] ?: ""
        }

    //save email into datastore
    suspend fun saveName(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = name
        }
    }

    val getDepartament: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_DEPARTAMENT_KEY] ?: ""
        }

    //save email into datastore
    suspend fun saveDepartament(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_DEPARTAMENT_KEY] = name
        }
    }

}