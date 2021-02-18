package com.mercadolibre.di

import com.mercadolibre.domain.SearchDomain
import com.mercadolibre.domain.SiteDomain
import com.mercadolibre.repository.RepositoryManager

/**
 * Class used to manage the components from application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
data class AppComponent(
    val repositoryManager: RepositoryManager,
    val searchDomain: SearchDomain,
    val siteDomain: SiteDomain
)
