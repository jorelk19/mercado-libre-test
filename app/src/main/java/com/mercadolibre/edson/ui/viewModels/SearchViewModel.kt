package com.mercadolibre.edson.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mercadolibre.domain.SearchDomain
import com.mercadolibre.edson.ui.models.SearchModel
import com.mercadolibre.edson.ui.viewModels.base.BaseViewModel
import com.mercadolibre.edson.utils.settingsSharedPreferences
import com.mercadolibre.models.business.Product
import com.mercadolibre.models.result.ISearchResult

/**
 * View model to manage the search result fragment and find the product required
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class SearchViewModel(private val searchDomain: SearchDomain) : BaseViewModel() {

    var searchModel = SearchModel()
    var currentProducts = MutableLiveData<ArrayList<Product>>()

    /**
     * Method to get the live data current products
     * */
    fun getProductsLiveData(): LiveData<ArrayList<Product>> {
        return currentProducts
    }

    /**
     * Implementation to get the search results
     * */
    private val searchResult = object : ISearchResult {
        override fun productResult(products: ArrayList<Product>) {
            currentProducts.value = products
        }
    }

    /**
     * Method to search product in services
     * */
    fun searchProduct() {
        searchDomain.errorManager = this
        searchDomain.searchProduct(searchModel.textSearched, searchResult, settingsSharedPreferences.getCurrentSite())
    }

    /**
     * Method to enable the search button
     * */
    fun setSearchEnable(charSequence: CharSequence) {
        searchModel.searchEnable = charSequence.length > 3
    }
}