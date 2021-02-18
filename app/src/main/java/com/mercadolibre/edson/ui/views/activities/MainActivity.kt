package com.mercadolibre.edson.ui.views.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mercadolibre.edson.R
import com.mercadolibre.edson.databinding.ActivityMainBinding
import com.mercadolibre.edson.ui.views.activities.base.BaseFragmentActivity
import com.mercadolibre.edson.ui.views.fragments.search.SearchFragment
import com.mercadolibre.edson.ui.views.fragments.site.SiteFragment
import com.mercadolibre.edson.utils.Navigation

/**
 * Principal activity that contain all fragments in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class MainActivity : BaseFragmentActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        initStore()
    }

    /**
     * Method to load the first fragment to chose the site for the searching products
     * */
    private fun initStore() {
        Navigation.attachFragment(fragmentTo = SiteFragment(), container = R.id.store_container_layout, addNewTransaction = true)
    }
}