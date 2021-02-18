package com.mercadolibre.edson.ui.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 * Model used to show data in product detail view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class ProductDetailModel : BaseObservable() {
    @Bindable
    var name: String = ""

    @Bindable
    var price: String = ""

    @Bindable
    var installmentDescription: String = ""

    @Bindable
    var productState: String = ""

    @Bindable
    var showInstallments: Boolean = false
}