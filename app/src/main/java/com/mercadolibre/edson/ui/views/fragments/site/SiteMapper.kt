package com.mercadolibre.edson.ui.views.fragments.site

import com.mercadolibre.edson.R

/**
 * Object used to map the different site identification and get the correct drawable
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
object SiteMapper {
    fun getImageSite(id: String): Int {
        return when (id) {
            "MGT" -> {
                R.drawable.guatemala
            }
            "MCO" -> {
                R.drawable.colombia
            }
            "MBO" -> {
                R.drawable.bolivia
            }
            "MPA" -> {
                R.drawable.panama
            }
            "MSV" -> {
                R.drawable.el_salvador
            }
            "MLU" -> {
                R.drawable.uruguay
            }
            "MEC" -> {
                R.drawable.ecuador
            }
            "MNI" -> {
                R.drawable.nicaragua
            }
            "MHN" -> {
                R.drawable.honduras
            }
            "MLM" -> {
                R.drawable.mexico
            }
            "MLB" -> {
                R.drawable.brasil
            }
            "MPE" -> {
                R.drawable.peru
            }
            "MPY" -> {
                R.drawable.paraguay
            }
            "MLC" -> {
                R.drawable.chile
            }
            "MLV" -> {
                R.drawable.venezuela
            }
            "MRD" -> {
                R.drawable.republica_dominicana
            }
            "MCR" -> {
                R.drawable.costa_rica
            }
            "MLA" -> {
                R.drawable.argentina
            }
            "MCU" -> {
                R.drawable.cuba
            }
            else -> {
                R.drawable.colombia
            }
        }
    }
}