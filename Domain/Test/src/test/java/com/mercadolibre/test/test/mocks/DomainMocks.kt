package com.mercadolibre.test.test.mocks

import com.mercadolibre.models.api.StoreApi
import com.mercadolibre.models.business.Address
import com.mercadolibre.models.business.Installments
import com.mercadolibre.models.business.Product
import com.mercadolibre.models.business.Site
import com.mercadolibre.models.errors.IErrorManager
import com.mercadolibre.models.response.ProductResponse
import com.mercadolibre.models.result.ISearchResult
import com.mercadolibre.models.result.ISiteResult
import retrofit2.HttpException

open class StoreApiMock : StoreApi{
    override suspend fun searchProduct(currentSite: String, product: String): ProductResponse {
        return productResponse
    }

    override suspend fun getSites(): ArrayList<Site> {
        return siteList
    }
}

/**Product mock*/
val productResponse = ProductResponse(
    products = productList,
    siteId = "MBA"
)

val productList: ArrayList<Product>
    get(){
        val list = arrayListOf<Product>()
        list.add(product1)
        list.add(product2)
        return list
    }


val product1 = Product(
    id = "1",
    siteId = "COL",
    title = "Control XBOX",
    sku = "PRODUCT_SKU",
    price = 9000F,
    currencyId = "COP",
    thumbnail ="image.png",
    address = Address(
        stateId = "CUND",
        stateName = "Cundinamarca",
        cityId = "BOG",
        cityName = "Bogotá"
    ),
    availableQuantity = 10,
    soldQuantity = 5,
    condition = "New",
    installments = Installments(
        quantity = 36,
        amount = 5300.62F,
        rate = 5F,
        currencyId = "COP"
    )
)

val product2 = Product(
    id = "2",
    siteId = "ARG",
    title = "Control PS5",
    sku = "PRODUCT_SKU_2",
    price = 100000F,
    currencyId = "ARG",
    thumbnail ="image2.png",
    address = Address(
        stateId = "BAI",
        stateName = "Buenos aires",
        cityId = "BAI",
        cityName = "Buenos aires"
    ),
    availableQuantity = 10,
    soldQuantity = 5,
    condition = "Used",
    installments = Installments(
        quantity = 28,
        amount = 6800.62F,
        rate = 10F,
        currencyId = "ARG"
    )
)

open class SearchResultMock : ISearchResult{
    override fun productResult(products: ArrayList<Product>) {
        productMockResult = products
    }
}

var productMockResult : ArrayList<Product>? = null

open class SiteResultMock : ISiteResult{
    override fun siteResult(sites: ArrayList<Site>) {
        sitesResultMock = sites
    }
}

var sitesResultMock : ArrayList<Site>? = null

val textSearched = "test"
val currentSite = "MCO"

/**Site mock*/
val siteList : ArrayList<Site>
    get(){
        val sites = arrayListOf<Site>()
        sites.add(siteCol)
        sites.add(siteArg)
        sites.add(siteBr)
        return sites
    }

val siteCol = Site(
    defaultCurrency = "COP",
    id = "MCO",
    name = "COLOMBIA"
)

val siteArg = Site(
    defaultCurrency = "ARG",
    id = "MAR",
    name = "ARGENTINA"
)

val siteBr = Site(
    defaultCurrency = "BRA",
    id = "MBR",
    name = "BRASIL"
)

/**Error manager*/
open class ErrorManagerMock : IErrorManager{
    override fun onServiceErrorHttpException(error: String?, httpException: HttpException) {

    }

    override fun onSocketTimeoutException(error: String?) {

    }

    override fun onIOException(error: String?) {

    }

    override fun onHideLoader() {

    }

    override fun onShowLoader() {

    }

}