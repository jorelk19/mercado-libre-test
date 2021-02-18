package com.mercadolibre.models.business

import com.google.gson.annotations.SerializedName

/**
 * Class used to map site information from the services
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
data class Site(
    @SerializedName("default_currency_id")
    val defaultCurrency : String,
    val id : String,
    val name : String
)