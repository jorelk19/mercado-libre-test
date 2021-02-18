package com.mercadolibre.models.result

import com.mercadolibre.models.business.Site

/**
 * Interface used to manage the site result from the services
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
interface ISiteResult {
    fun siteResult(sites : ArrayList<Site>)
}