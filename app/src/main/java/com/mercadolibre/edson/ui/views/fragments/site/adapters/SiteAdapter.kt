package com.mercadolibre.edson.ui.views.fragments.site.adapters

import android.annotation.SuppressLint
import android.content.Context
import com.mercadolibre.edson.R
import com.mercadolibre.edson.databinding.LayoutSiteItemBinding
import com.mercadolibre.edson.ui.views.fragments.search.SearchFragment
import com.mercadolibre.edson.ui.views.fragments.site.SiteMapper
import com.mercadolibre.edson.utils.GenericAdapter
import com.mercadolibre.edson.utils.Navigation
import com.mercadolibre.edson.utils.loadLocalImage
import com.mercadolibre.edson.utils.settingsSharedPreferences
import com.mercadolibre.models.business.Site

/**
 * Class used to manage the adapter to load sites in recycler view
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
class SiteAdapter(private val context: Context, arrayList: ArrayList<Site>) : GenericAdapter<Site, LayoutSiteItemBinding>(context, arrayList) {
    override fun getLayoutResId(): Int {
        return R.layout.layout_site_item
    }

    /**
     * Method to set the data in the recycler view layout
     * */
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindData(model: Site, position: Int, dataBinding: LayoutSiteItemBinding) {
        dataBinding.tvSiteName.text = model.name
        dataBinding.ivCountryFlag.loadLocalImage(SiteMapper.getImageSite(model.id))
        setListeners(dataBinding, model)
    }

    /**
     * Method used to set the listeners for container and launch search fragment
     * */
    private fun setListeners(dataBinding: LayoutSiteItemBinding, model: Site) {
        dataBinding.siteContainer.setOnClickListener {
            settingsSharedPreferences.setSite(model.id)
            Navigation.attachFragment(fragmentTo = SearchFragment(), container = R.id.store_container_layout, addNewTransaction = true)
        }
    }
}