package com.mercadolibre.models.api

import com.mercadolibre.models.business.Site
import com.mercadolibre.models.response.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Interface that represent the endpoints in the services
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
interface StoreApi {
    @GET("/sites/{site}/search")
    suspend fun searchProduct(@Path("site") currentSite: String, @Query("q") product: String) : ProductResponse
    @GET("/sites")
    suspend fun getSites() : ArrayList<Site>
}