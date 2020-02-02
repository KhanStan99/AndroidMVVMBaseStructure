package `in`.trentweet.basetemplate.ui.mainactivity

import `in`.trentweet.basetemplate.R
import `in`.trentweet.basetemplate.common.Logger
import `in`.trentweet.basetemplate.services.models.HolidaysList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class MainActivity : AppCompatActivity(), KodeinAware,
    HomeListener {

    lateinit var viewModel: MainActivityViewModel
    override val kodein by kodein()
    private val factory: MainViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)

        setContentView(R.layout.activity_main)
        viewModel.homeListener = this
        viewModel.fetchTopHighlights()
    }

    override fun onApiSuccess(list: HolidaysList) {
        Logger.error("Play with your response", list.meta.toString())
    }

    override fun onApiFailure(message: String) {
        Logger.error("This is the error: ", message)
    }
}
