package k.bs.calculator.util

import android.app.Application
import java.lang.ref.WeakReference

object AppInstance {
    var instance: WeakReference<Application>? = null

    fun get(): Application? {
        if (instance == null || instance!!.get() == null) {
            if (getApplication() != null)
                instance = WeakReference(getApplication()!!)
        }
        return instance?.get()
    }

    private fun getApplication(): Application? {
        return try {
            val className = Class.forName("android.app.ActivityThread")
            val method = className.getMethod("currentApplication")
            method.invoke(null, *arrayOfNulls<Any>(0)) as Application
        } catch (e: ClassNotFoundException) {
            null
        }
    }
}