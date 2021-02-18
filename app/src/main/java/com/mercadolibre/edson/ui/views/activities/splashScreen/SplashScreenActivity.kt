package com.mercadolibre.edson.ui.views.activities.splashScreen

import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.mercadolibre.edson.R
import com.mercadolibre.edson.databinding.ActivitySplashScreenBinding
import com.mercadolibre.edson.ui.views.activities.MainActivity
import com.mercadolibre.edson.ui.views.activities.base.BaseFragmentActivity
import com.mercadolibre.edson.utils.Navigation

/***
 * Activity used to show a splash screen when the application start
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class SplashScreenActivity : BaseFragmentActivity() {

    private lateinit var activitySplashScreenBinding: ActivitySplashScreenBinding

    /**
    * Constant declaration
    * */
    companion object{
        private const val DELAY_TIME = 2000L
    }

    /**
     * Method that allow load Splashscreen and redirect to main activity
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplashScreenBinding = DataBindingUtil.setContentView(this@SplashScreenActivity, R.layout.activity_splash_screen)

        Handler().postDelayed(Runnable {
            Navigation.goTo(MainActivity::class.java)
            this.finish()
        }, DELAY_TIME)
    }
}