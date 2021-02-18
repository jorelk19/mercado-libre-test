package com.mercadolibre.di

import com.mercadolibre.domain.SearchDomain
import com.mercadolibre.domain.SiteDomain
import com.mercadolibre.repository.RepositoryManager
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Class used to manage the koin component that can be used in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class StoreComponent : KoinComponent {
    private val repositoryManager : RepositoryManager by inject()
    private val searchDomain : SearchDomain by inject()
    private val siteDomain : SiteDomain by inject()
    val appComponent = AppComponent (
        repositoryManager = repositoryManager,
        searchDomain = searchDomain,
        siteDomain = siteDomain
    )
}

val appComponent by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { StoreComponent().appComponent }