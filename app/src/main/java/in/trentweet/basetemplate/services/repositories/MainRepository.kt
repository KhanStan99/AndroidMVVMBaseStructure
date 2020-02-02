package `in`.trentweet.basetemplate.services.repositories

import `in`.trentweet.basetemplate.services.ApiInstance
import `in`.trentweet.basetemplate.services.models.HolidaysList
import `in`.trentweet.basetemplate.services.SafeApiRequest


class MainRepository(
    private val api: ApiInstance
) : SafeApiRequest() {

    suspend fun getList(): HolidaysList {
        return apiRequest { api.getHeadlines("IN", "2020") }
    }
}