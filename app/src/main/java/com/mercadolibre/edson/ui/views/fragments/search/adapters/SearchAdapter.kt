package com.mercadolibre.edson.ui.views.fragments.search.adapters

import android.content.Context
import com.mercadolibre.edson.R
import com.mercadolibre.edson.databinding.LayoutSearchItemBinding
import com.mercadolibre.edson.ui.views.fragments.productDetail.ProductDetailFragment
import com.mercadolibre.edson.utils.GenericAdapter
import com.mercadolibre.edson.utils.Navigation
import com.mercadolibre.edson.utils.loadImage
import com.mercadolibre.edson.utils.toCurrencyFormat
import com.mercadolibre.models.business.Product

/**
 * Class used to manage the recycler view into the search view and show the product list
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class SearchAdapter(context: Context?, arrayList: ArrayList<Product>) : GenericAdapter<Product, LayoutSearchItemBinding>(context, arrayList) {
    override fun getLayoutResId(): Int {
        return R.layout.layout_search_item
    }

    /**
     * Method that in charge of manage the product information and load it in the recycler view layout
     * */
    override fun onBindData(model: Product, position: Int, dataBinding: LayoutSearchItemBinding) {
        dataBinding.ivProductImage.loadImage(model.thumbnail)
        dataBinding.tvProductName.text = model.title
        dataBinding.tvProductPrice.text = model.price.toCurrencyFormat()
        setListener(model, dataBinding)
    }

    /**
     * Method to set the listener necessary to launch the product detail view
     * */
    private fun setListener(model: Product, dataBinding: LayoutSearchItemBinding) {
        dataBinding.productContainer.setOnClickListener {
            Navigation.attachFragment(fragmentTo = ProductDetailFragment.newInstance(model), container = R.id.store_container_layout, addNewTransaction = true)
        }
    }
}