package com.mercadolibre.models.result

import com.mercadolibre.models.business.Product

/**
 * Interface used to manage the search result
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
interface ISearchResult {
    fun productResult(products: ArrayList<Product>)
}