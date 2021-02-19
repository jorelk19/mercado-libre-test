package com.mercadolibre.edson.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mercadolibre.edson.R
import com.mercadolibre.edson.ui.models.ProductDetailModel
import com.mercadolibre.edson.ui.viewModels.base.BaseViewModel
import com.mercadolibre.edson.utils.Navigation
import com.mercadolibre.edson.utils.toCurrencyFormat
import com.mercadolibre.models.business.Product

/**
 * Class used to manage the view model and it interaction with the model and domain
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class ProductDetailViewModel : BaseViewModel() {
    var productDetailModel = ProductDetailModel()
    var productImage = MutableLiveData<String>()

    /**
     * Live data to get the image products
     * */
    fun getProductImageLiveData(): LiveData<String> {
        return productImage
    }

    /**
     * Method used to set the product detail data and validate the visibility
     * */
    fun setProductDetailData(product: Product) {
        productImage.value = product.thumbnail
        productDetailModel.name = product.title
        productDetailModel.price = product.price.toCurrencyFormat()
        productDetailModel.productState = "${Navigation.getString(R.string.product_state_title)} ${product.condition}"
        product.installments?.let { installments ->
            productDetailModel.showInstallments = true
            productDetailModel.installmentDescription = "${installments.quantity} ${Navigation.getString(R.string.installment)} ${installments.amount.toCurrencyFormat()}"
        } ?: run {
            productDetailModel.showInstallments = false
        }
        product.address?.let {
            productDetailModel.locationDescription = "${it.stateName} - ${it.cityName}"
        }
    }
}