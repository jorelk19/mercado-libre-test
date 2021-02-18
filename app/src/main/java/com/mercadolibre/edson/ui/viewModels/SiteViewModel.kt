package com.mercadolibre.edson.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.mercadolibre.domain.SiteDomain
import com.mercadolibre.edson.ui.viewModels.base.BaseViewModel
import com.mercadolibre.models.business.Product
import com.mercadolibre.models.business.Site
import com.mercadolibre.models.result.ISiteResult

/**
 * View model to manage the site fragment and load the sites that are allowed in Mercado Libre
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class SiteViewModel(private val siteDomain: SiteDomain) : BaseViewModel() {
    var currentSites = MutableLiveData<ArrayList<Site>>()

    /**
     * Method to get the sites live data to show into view
     * */
    fun getSitesLiveData(): LiveData<ArrayList<Site>> {
        return currentSites
    }

    /**
     * Variable to implement the site result that are getting of site service
     * */
    private val siteResult = object : ISiteResult {
        override fun siteResult(sites: ArrayList<Site>) {
            currentSites.value = sites
        }
    }

    /**
     * Method to load sites from the domain through the services
     * */
    fun loadSites() {
        siteDomain.errorManager = this
        siteDomain.getSites(siteResult)
    }
}