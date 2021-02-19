package com.mercadolibre.test.test.domain

import com.mercadolibre.domain.SearchDomain
import com.mercadolibre.domain.SiteDomain
import com.mercadolibre.repository.RepositoryManager
import com.mercadolibre.test.test.mocks.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class DomainTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private lateinit var searchDomain: SearchDomain
    private lateinit var siteDomain: SiteDomain
    private lateinit var storeApiMock: StoreApiMock
    private lateinit var repositoryManager: RepositoryManager
    private lateinit var errorManagerMock: ErrorManagerMock

    @Before
    fun setUp() {
        storeApiMock = StoreApiMock()
        repositoryManager = RepositoryManager(storeApiMock)
        searchDomain = SearchDomain(repositoryManager)
        siteDomain = SiteDomain(repositoryManager)
        errorManagerMock = ErrorManagerMock()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun resetCoroutines() {
        // Resets state of the [Dispatchers.Main] to the original main dispatcher.
        // For example, in Android Main thread dispatcher will be set as [Dispatchers.Main].
        Dispatchers.resetMain()

        // Clean up the TestCoroutineDispatcher to make sure no other work is running.
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun searchProductTest() {
        //WHEN
        searchDomain.errorManager = errorManagerMock
        searchDomain.searchProduct(text = textSearched, searchResult = SearchResultMock(), currentSite = currentSite)
        Thread.sleep(5000)
        //THEN
        productMockResult?.let {
            Assert.assertTrue(it.size == 2)
        }
    }

    @Test
    fun getSiteTest() {
        //WHEN
        siteDomain.errorManager = errorManagerMock
        siteDomain.getSites(siteResults = SiteResultMock())
        Thread.sleep(5000)
        //THEN
        sitesResultMock?.let {
            Assert.assertTrue(it.size == 3)
        }
    }
}