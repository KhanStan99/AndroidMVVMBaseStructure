package `in`.trentweet.basetemplate.services

import `in`.trentweet.basetemplate.services.models.HolidaysList
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiInstance {

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): ApiInstance {

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("https://calendarific.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInstance::class.java)
        }
    }

    @GET("holidays")
    suspend fun getHeadlines(
        @Query("country") countryCode: String,
        @Query("year") year: String
    ): Response<HolidaysList>

}