package elshod.myproject.sharedPreference

import android.content.Context
import android.content.SharedPreferences

class MyShared(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("my_shared", Context.MODE_PRIVATE)

    fun saveData(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getData(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }
}