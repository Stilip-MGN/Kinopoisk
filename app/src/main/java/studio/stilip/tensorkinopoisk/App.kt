package studio.stilip.tensorkinopoisk

import android.app.Application
import studio.stilip.tensorkinopoisk.di.AppComponent
import studio.stilip.tensorkinopoisk.di.DaggerAppComponent
import timber.log.Timber

class App: Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(applicationContext)
        initLogger()
    }

    /**
     * Initialize Timber logger tree
     */
    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}