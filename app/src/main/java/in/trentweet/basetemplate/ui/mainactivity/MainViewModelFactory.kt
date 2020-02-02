package `in`.trentweet.basetemplate.ui.mainactivity

import `in`.trentweet.basetemplate.services.repositories.MainRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val repository: MainRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}