package com.mercadolibre.edson.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mercadolibre.di.appComponent
import com.mercadolibre.edson.ui.models.SearchModel
import com.mercadolibre.edson.ui.viewModels.ProductDetailViewModel
import com.mercadolibre.edson.ui.viewModels.SearchViewModel
import com.mercadolibre.edson.ui.viewModels.SiteViewModel

/**
 * Class used to create view models through factory pattern
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    /**
     * Method to return instance from specific view model
     * */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass)
        {
            when {
                isAssignableFrom(SearchViewModel::class.java) -> SearchViewModel(appComponent.searchDomain)
                isAssignableFrom(SiteViewModel::class.java) -> SiteViewModel(appComponent.siteDomain)
                isAssignableFrom(ProductDetailViewModel::class.java) -> ProductDetailViewModel()
                else -> throw IllegalStateException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}