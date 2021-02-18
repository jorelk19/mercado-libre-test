package com.mercadolibre.di

import com.mercadolibre.models.api.StoreApi
import com.mercadolibre.repository.RepositoryManager
import org.koin.dsl.module

/**
 * Variable used to load the repository modules that can be used in the application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
val repositoryModule = module {
    single { provideStoreRepository(get()) }
}

private fun provideStoreRepository(storeApi: StoreApi) = RepositoryManager(storeApi)
