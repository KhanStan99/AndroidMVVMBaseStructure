package `in`.trentweet.basetemplate

import `in`.trentweet.basetemplate.common.PreferenceProvider
import `in`.trentweet.basetemplate.services.ApiInstance
import `in`.trentweet.basetemplate.services.NetworkConnectionInterceptor
import `in`.trentweet.basetemplate.services.repositories.MainRepository
import `in`.trentweet.basetemplate.ui.mainactivity.MainViewModelFactory
import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MyApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApplication))

        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { NetworkConnectionInterceptor(instance(), instance()) }
        bind() from singleton { ApiInstance(instance()) }
        bind() from singleton { MainRepository(instance()) }
        bind() from singleton { MainViewModelFactory(instance()) }

    }
}