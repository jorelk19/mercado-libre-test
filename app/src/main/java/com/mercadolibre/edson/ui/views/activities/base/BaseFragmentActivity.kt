package com.mercadolibre.edson.ui.views.activities.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import com.mercadolibre.edson.utils.Navigation

/**
 * Class used to manage the activities in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
open class BaseFragmentActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Navigation.setCurrentActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Navigation.setCurrentActivity(this)
    }

    override fun onResume() {
        super.onResume()
        Navigation.setCurrentActivity(this)
    }

    override fun onBackPressed() {
        Navigation.onBack()
    }
}