package k.bs.calculator.preference


import android.content.SharedPreferences
import android.preference.PreferenceManager
import k.bs.calculator.util.AppInstance


object PreferencesHelper {

    private val sharedPreferences: SharedPreferences?
        get() =
            if (AppInstance.get() != null)
                PreferenceManager.getDefaultSharedPreferences(AppInstance.get())
            else
                null

    fun clear() {
        sharedPreferences
            ?.edit()
            ?.clear()
            ?.apply()
    }

    operator fun set(key: Any, anyValue: Any) {
        set(key, anyValue.toString())
    }

    operator fun set(key: Any, value: CharSequence) {
        sharedPreferences
            ?.edit()
            ?.putString(key.toString(), value.toString())
            ?.apply()
    }


    operator fun get(any: Any, defaultValue: Any): String {
        return get(any, defaultValue.toString())
    }

    @JvmOverloads
    operator fun get(key: Any, defaultValue: String = ""): String {
        return sharedPreferences
            ?.getString(key.toString(), defaultValue) ?: defaultValue
    }

    fun remove(key: Any) {
        sharedPreferences
            ?.edit()
            ?.remove(key.toString())
            ?.apply()
    }
}