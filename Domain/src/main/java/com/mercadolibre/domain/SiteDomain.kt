package com.mercadolibre.domain

import com.mercadolibre.domain.base.DomainBase
import com.mercadolibre.models.result.ISiteResult
import com.mercadolibre.repository.RepositoryManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Class used to access the site information from services
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class SiteDomain(private val repositoryManager: RepositoryManager) : DomainBase() {
    fun getSites(siteResults: ISiteResult) {
        launch(Dispatchers.Main) {
            try {
                errorManager.onShowLoader()
                val sites = withContext(Dispatchers.IO) { repositoryManager.getSites() }
                siteResults.siteResult(sites)
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