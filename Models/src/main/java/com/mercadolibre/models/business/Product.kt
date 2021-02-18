package com.mercadolibre.models.business

import com.google.gson.annotations.SerializedName

/**
 * Class used to map product information from the services
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
data class Product(
    val id : String,
    @SerializedName("site_id")
    val siteId: String,
    val title : String,
    val sku : String,
    val price : Float,
    @SerializedName("currency_id")
    val currencyId : String,
    val thumbnail : String,
    val address : Address,
    @SerializedName("available_quantity")
    val availableQuantity : Int,
    @SerializedName("sold_quantity")
    val soldQuantity : Int,
    val condition : String,
    val installments: Installments? = null
)