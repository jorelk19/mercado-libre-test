package com.mercadolibre.models.business

import com.google.gson.annotations.SerializedName

/**
 * Class used to map the installments from the services
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
data class Installments(
    val quantity: Int,
    val amount: Float,
    val rate: Float,
    @SerializedName("currency_id")
    val currencyId: String
)