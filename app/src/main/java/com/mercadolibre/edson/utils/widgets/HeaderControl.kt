package com.mercadolibre.edson.utils.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mercadolibre.edson.R
import com.mercadolibre.edson.databinding.LayoutHeaderControlBinding
import com.mercadolibre.edson.utils.Navigation


/***
 * Header control used in all views in application
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * * */
class HeaderControl : BaseControl {
    private lateinit var layoutHeaderControlBinding: LayoutHeaderControlBinding
    var mContext: Context
    private var title : String = ""
    private var isBackVisibility : Boolean = false

    constructor(context: Context) : super(context) {
        mContext = context
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        mContext = context
        getAttributes(attributeSet)
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttribute: Int) : super(
        context,
        attributeSet,
        defStyleAttribute
    ) {
        mContext = context
        getAttributes(attributeSet)
        init()
    }

    /***
     * Method to get attributes from control
     * */
    private fun getAttributes(attrs: AttributeSet?) {
        attrs?.let {
            val attributes = mContext.obtainStyledAttributes(attrs, R.styleable.HeaderControl)
            title = attributes.getString(R.styleable.HeaderControl_headerWindowTitle) ?: ""
            isBackVisibility = attributes.getBoolean(R.styleable.HeaderControl_headerBackVisibility, false)
            attributes.recycle()
        }
    }

    /***
     * load the header configuration to use in the screen
     * */
    private fun init() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutHeaderControlBinding = DataBindingUtil.inflate(inflater, R.layout.layout_header_control, this, true)
        layoutHeaderControlBinding.tvHeaderScreenTitle.text = title
        layoutHeaderControlBinding.ivHeaderBack.visibility = if (isBackVisibility)  View.VISIBLE else View.GONE
        layoutHeaderControlBinding.ivHeaderBack.setColorFilter(android.R.color.white)
        layoutHeaderControlBinding.ivHeaderBack.setOnClickListener { Navigation.onBack() }
    }
}