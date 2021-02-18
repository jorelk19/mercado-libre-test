package com.mercadolibre.edson.ui.views.fragments.productDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mercadolibre.edson.R
import com.mercadolibre.edson.databinding.ProductDetailFragmentBinding
import com.mercadolibre.edson.ui.viewModels.ProductDetailViewModel
import com.mercadolibre.edson.utils.getViewModelFactory
import com.mercadolibre.edson.utils.loadImage
import com.mercadolibre.models.business.Product

/**
 * Class used to manage the product detail
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class ProductDetailFragment : Fragment() {
    private lateinit var productDetailFragmentBinding: ProductDetailFragmentBinding
    private val viewModel by viewModels<ProductDetailViewModel> { getViewModelFactory() }
    private var currentProduct : Product? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        productDetailFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.product_detail_fragment, container, false)
        productDetailFragmentBinding.productDetailModel = viewModel
        addSubscriptions()
        currentProduct?.let {
            viewModel.setProductDetailData(it)
        }
        return productDetailFragmentBinding.root
    }

    /**
     * Subscription to observe when the product image is loaded
     * */
    private fun addSubscriptions() {
        viewModel.getProductImageLiveData().observe(viewLifecycleOwner, { imageUrl ->
            productDetailFragmentBinding.ivProductImage.loadImage(imageUrl)
        })
    }

    /**
     * Method used to set the current product data and return instance
     * */
    companion object{
        fun newInstance(product : Product) : ProductDetailFragment{
            val instance = ProductDetailFragment()
            instance.setCurrentProduct(product)
            return instance
        }
    }

    /**
     * Method to set the current product to show its data
     * */
    private fun setCurrentProduct(product: Product) {
        currentProduct = product
    }
}