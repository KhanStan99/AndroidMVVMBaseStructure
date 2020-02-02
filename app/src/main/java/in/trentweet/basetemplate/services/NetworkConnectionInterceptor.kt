package `in`.trentweet.basetemplate.services

import `in`.trentweet.basetemplate.common.Logger
import `in`.trentweet.basetemplate.common.NoInternetException
import `in`.trentweet.basetemplate.common.PreferenceProvider
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer
import java.io.IOException


class NetworkConnectionInterceptor(
    context: Context,
    private val preferences: PreferenceProvider
) : Interceptor {

    private val applicationContext = context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetAvailable())
            throw NoInternetException("Make sure you have an active data connection")
        val request =
            chain.request().newBuilder()
                .addHeader("x-rapidapi-key", "xHjPEqdOSVmshSxKAnUTUp6WK2Zdp14Yq87jsnxRwtyyoUmyAV")
                .build()
        logApiCall(chain)
        return chain.proceed(request)
    }

    private fun isInternetAvailable(): Boolean {
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected

    }

    private fun logApiCall(chain: Interceptor.Chain) {
        Logger.error("**************************", "**************************")
        Logger.error("BODY", stringifyRequestBody(chain.request()))
        Logger.error("METHOD", chain.request().method())
        Logger.error("HEADERS", "UO: " + chain.request().headers().toString())
        Logger.error("URL", chain.request().url().toString())
        Logger.error("**************************", "**************************")
    }

    private fun stringifyRequestBody(request: Request): String {
        if (request.body() != null) {
            try {
                val copy = request.newBuilder().build()
                val buffer = Buffer()
                copy.body()!!.writeTo(buffer)
                return buffer.readUtf8()
            } catch (e: IOException) {
                Log.w("Error: ", "Failed to stringify request body")
            }

        }
        return "Nothing to print *_*"
    }


}