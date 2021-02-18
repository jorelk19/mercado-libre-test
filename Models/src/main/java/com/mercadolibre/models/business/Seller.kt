package com.mercadolibre.models.business

import com.google.gson.annotations.SerializedName

/**
 * Class used to map seller information from the services
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
data class Seller(
    val id : Long,
    val permalink : String,
    @SerializedName("eshop_logo_url")
    val shopLogoUrl : String
)