package com.mercadolibre.edson.ui.viewModels.base

import androidx.lifecycle.ViewModel
import com.mercadolibre.edson.R
import com.mercadolibre.edson.utils.Navigation
import com.mercadolibre.edson.utils.SnackFactory
import com.mercadolibre.models.errors.IErrorManager
import retrofit2.HttpException

/**
 * This class in charge of manage the errors that can be occurred in the domain
 * when a services is executed
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
open class BaseViewModel : ViewModel(), IErrorManager {
    /**
     * Method to manage the http exception
     * */
    override fun onServiceErrorHttpException(error: String?, httpException: HttpException) {
        Navigation.hideLoader()
        SnackFactory.showErrorMessage(httpException = httpException, resource = R.id.coordinator_main_activity, fragmentActivity = Navigation.getCurrentActivity())
    }

    /**
     * Method to manage the socket time out exception
     * */
    override fun onSocketTimeoutException(error: String?) {
        Navigation.hideLoader()
        SnackFactory.showWarningMessage(fragmentActivity = Navigation.getCurrentActivity(), resource = R.id.coordinator_main_activity, error?.let{ it } ?: run { Navigation.getString(R.string.something_went_wrong_retry) })
    }

    /**
     * Method to manage the IO exception
     * */
    override fun onIOException(error: String?) {
        Navigation.hideLoader()
        SnackFactory.showWarningMessage(fragmentActivity = Navigation.getCurrentActivity(), resource = R.id.coordinator_main_activity, error?.let{ it } ?: run { Navigation.getString(R.string.something_went_wrong_retry) })
    }

    /**
     * Method to hide the loader
     * */
    override fun onHideLoader() {
        Navigation.hideLoader()
    }

    /**
     * Method to show the loader
     * */
    override fun onShowLoader(){
        Navigation.showLoader()
    }
}