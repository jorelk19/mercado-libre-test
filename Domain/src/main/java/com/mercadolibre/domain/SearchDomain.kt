package com.mercadolibre.domain

import com.mercadolibre.domain.base.DomainBase
import com.mercadolibre.models.result.ISearchResult
import com.mercadolibre.repository.RepositoryManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Class used to access the search product information from the services
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class SearchDomain(private val repositoryManager: RepositoryManager) : DomainBase() {
    fun searchProduct(text: String, searchResult: ISearchResult, currentSite: String) {
        launch(Dispatchers.Main) {
            try {
                errorManager.onShowLoader()
                val productResponse = withContext(Dispatchers.IO) { repositoryManager.searchProduct(currentSite, text) }
                searchResult.productResult(productResponse.products)
                errorManager.onHideLoader()
            } catch (exception: HttpException) {
                errorManager.onServiceErrorHttpException(exception.message, exception)
            } catch (exception: SocketTimeoutException) {
                errorManager.onSocketTimeoutException(exception.message)
            } catch (exception: IOException) {
                errorManager.onSocketTimeoutException(exception.message)
            }
        }
    }
}