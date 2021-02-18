package com.mercadolibre.edson.app

import android.content.Context
import com.mercadolibre.di.KoinManager
import com.mercadolibre.edson.BuildConfig

/**
 * Class used to get the application instance and call the koin dependency injection
 * @since 1.0.0
 * */
class App : BaseApplication() {

    /**
     * Get the application context
     * */
    companion object {
        private lateinit var appContext: Context
        final fun getAppContext(): Context = appContext
    }

    /**
     * Method that allow start koin dependency injection
     * */
    override fun onAppStart() {
        appContext = this
        KoinManager.initKoin(BuildConfig.STORE_API)
    }

    override fun onAppDestroy() {
    }
}