package com.mercadolibre.models.response

import com.google.gson.annotations.SerializedName
import com.mercadolibre.models.business.Product

/**
 * Class used to map the product response from the services
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
data class ProductResponse(
    @SerializedName("results")
    val products : ArrayList<Product> = arrayListOf(),
    @SerializedName("site_id")
    val siteId: String
)