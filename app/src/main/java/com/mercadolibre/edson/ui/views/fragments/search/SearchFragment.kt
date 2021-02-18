package com.mercadolibre.edson.ui.views.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mercadolibre.edson.R
import com.mercadolibre.edson.databinding.SearchFragmentBinding
import com.mercadolibre.edson.ui.viewModels.SearchViewModel
import com.mercadolibre.edson.ui.views.fragments.search.adapters.SearchAdapter
import com.mercadolibre.edson.utils.Navigation
import com.mercadolibre.edson.utils.doOnTextChange
import com.mercadolibre.edson.utils.getViewModelFactory

/**
 * Class used to show the search view and show the products that are searched in the service
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class SearchFragment : Fragment() {

    private lateinit var searchFragmentBinding: SearchFragmentBinding
    private val viewModel by viewModels<SearchViewModel> { getViewModelFactory() }
    private var searchAdapter: SearchAdapter? = null


    /**
     * Method to get the layout to use in the fragment
     * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        searchFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false)
        searchFragmentBinding.searchViewModel = viewModel
        setListeners()
        setAdapter()
        addSubscriptions()
        return searchFragmentBinding.root
    }

    /**
     * Method used to set the adapters that are used in the recycler view
     * */
    private fun setAdapter() {
        searchAdapter = SearchAdapter(Navigation.getCurrentActivity(), arrayListOf())
        searchFragmentBinding.rvItemSearched.adapter = searchAdapter
        searchFragmentBinding.rvItemSearched.layoutManager = LinearLayoutManager(Navigation.getCurrentActivity())
    }

    /**
     * Method that contain the subscriptions to observe when the products are loaded from the services
     * */
    private fun addSubscriptions() {
        viewModel.getProductsLiveData().observe(viewLifecycleOwner, { products ->
            searchAdapter?.addItems(products)
        })
    }

    /**
     * Method used to set the listeners to manage when the text is changed and enable the search button
     * */
    private fun setListeners() {
        searchFragmentBinding.etSearchProduct.doOnTextChange { s -> viewModel.setSearchEnable(s) }
        searchFragmentBinding.ivSearchProduct.setOnClickListener { viewModel.searchProduct() }
    }
}