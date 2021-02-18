package com.mercadolibre.edson.ui.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 * Model used to show data in search view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class SearchModel : BaseObservable() {
    @Bindable
    var searchEnable : Boolean = true
    @Bindable
    var textSearched: String = ""
}