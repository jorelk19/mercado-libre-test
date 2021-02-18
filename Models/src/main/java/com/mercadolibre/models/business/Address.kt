package com.mercadolibre.models.business

import com.google.gson.annotations.SerializedName

/**
 * Class used to map the contract address from the services
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
data class Address(
    @SerializedName("state_id")
    val stateId : String,
    @SerializedName("state_name")
    val stateName : String,
    @SerializedName("city_id")
    val cityId : String,
    @SerializedName("city_name")
    val cityName : String
)