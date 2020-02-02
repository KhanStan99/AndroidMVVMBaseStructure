package `in`.trentweet.basetemplate.ui.mainactivity

import `in`.trentweet.basetemplate.services.models.HolidaysList


interface HomeListener {
    fun onApiSuccess(list: HolidaysList)
    fun onApiFailure(message: String)
}