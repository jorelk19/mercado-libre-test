package com.mercadolibre.edson.ui.views.fragments.site

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mercadolibre.edson.R
import com.mercadolibre.edson.databinding.SiteFragmentBinding
import com.mercadolibre.edson.ui.viewModels.SiteViewModel
import com.mercadolibre.edson.ui.views.fragments.site.adapters.SiteAdapter
import com.mercadolibre.edson.utils.Navigation
import com.mercadolibre.edson.utils.getViewModelFactory

/**
 * Class used to manage the sites view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class SiteFragment : Fragment() {
    private lateinit var siteFragmentBinding: SiteFragmentBinding
    private val viewModel by viewModels<SiteViewModel> { getViewModelFactory() }
    private var siteAdapter : SiteAdapter? = null

    /**
     * Method that allow get the site fragment layout
     * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        siteFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.site_fragment, container, false)
        loadSites()
        setAdapter()
        addSubscriptions()
        return siteFragmentBinding.root
    }

    /**
     * Method used to set adapter to show site information list
     * */
    private fun setAdapter() {
        siteAdapter = SiteAdapter(Navigation.getCurrentActivity(), arrayListOf())
        siteFragmentBinding.rvSite.adapter = siteAdapter
        siteFragmentBinding.rvSite.layoutManager = GridLayoutManager(Navigation.getCurrentActivity(), 2)
    }

    /**
     * Method to manage the subscription and observe the sites when information is loaded from the services
     * */
    private fun addSubscriptions() {
        viewModel.getSitesLiveData().observe(viewLifecycleOwner, { sites ->
            siteAdapter?.addItems(sites)
        })
    }

    /**
     * Method to load sites from the view model
     * */
    private fun loadSites() {
        viewModel.loadSites()
    }
}