package com.mercadolibre.di

import com.mercadolibre.domain.SearchDomain
import com.mercadolibre.domain.SiteDomain
import com.mercadolibre.repository.RepositoryManager
import org.koin.dsl.module

/**
 * Variable used to load the domain modules that can be used in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
val domainModule = module {
    single { provideStoreDomain(get()) }
    single { provideSiteDomain(get()) }
}

private fun provideStoreDomain(repositoryManager: RepositoryManager) = SearchDomain(repositoryManager)
private fun provideSiteDomain(repositoryManager: RepositoryManager) = SiteDomain(repositoryManager)
