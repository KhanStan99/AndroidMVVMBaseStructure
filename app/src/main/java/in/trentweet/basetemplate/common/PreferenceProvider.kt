package `in`.trentweet.basetemplate.common

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager


class PreferenceProvider(
    context: Context
) {

    private val appContext = context.applicationContext

    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)

    fun saveHighlightsDate(api: String) {
        preference.edit().putString(
            api,
            ""
        ).apply()
    }

    fun isApiCallRequired(api: String) {
        preference.getInt(api, 0)
    }

    fun clearAppSharedPref() {
        preference.edit().clear().apply()
    }

}