package `in`.trentweet.basetemplate.common

import `in`.trentweet.basetemplate.BuildConfig
import android.util.Log

class Logger {
    companion object {
        fun error(tag: String, message: String) {
            if (BuildConfig.DEBUG)
                Log.e(tag, message)
        }
    }
}