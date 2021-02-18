package com.mercadolibre.repository

import com.mercadolibre.models.api.StoreApi
import com.mercadolibre.models.business.Site
import com.mercadolibre.models.response.ProductResponse

/**
 * Class used to manage the repository data and return correct information
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class RepositoryManager(private val storeApi: StoreApi) {
    /**
     * Method to access the search product result
     * */
    suspend fun searchProduct(currentSite: String, text: String): ProductResponse {
        return storeApi.searchProduct(currentSite, text)
    }

    /**
     * Method to get the sites and return the correct list
     * */
    suspend fun getSites(): ArrayList<Site> {
        return storeApi.getSites()
    }
}