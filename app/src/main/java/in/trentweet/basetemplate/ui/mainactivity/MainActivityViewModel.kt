package `in`.trentweet.basetemplate.ui.mainactivity

import `in`.trentweet.basetemplate.common.ApiException
import `in`.trentweet.basetemplate.common.Coroutines
import `in`.trentweet.basetemplate.common.NoInternetException
import `in`.trentweet.basetemplate.services.repositories.MainRepository
import androidx.lifecycle.ViewModel


class MainActivityViewModel(val repository: MainRepository) : ViewModel() {

    var homeListener: HomeListener? = null

    fun fetchTopHighlights() {
        Coroutines.main {
            try {
                val response = repository.getList()
                homeListener?.onApiSuccess(response)
            } catch (e: ApiException) {
                homeListener?.onApiFailure(e.message!!)
            } catch (e: NoInternetException) {
                homeListener?.onApiFailure(e.message!!)
            }
        }
    }
}