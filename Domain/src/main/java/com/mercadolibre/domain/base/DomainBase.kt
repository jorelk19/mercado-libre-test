package com.mercadolibre.domain.base

import com.mercadolibre.models.errors.IErrorManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Class used to inheritance in the domain models to manage the coroutines
 * @author Edson Joel Nieto Ardila
 * @since 1.0.0
 * */
open class DomainBase : CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    lateinit var errorManager : IErrorManager
}