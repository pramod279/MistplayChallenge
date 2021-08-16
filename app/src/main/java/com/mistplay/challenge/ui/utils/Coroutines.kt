package com.mistplay.challenge.ui.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Coroutines Helper Class
 *
 * Created by Pramod Selvaraj on 13/08/2021.
 */
object Coroutines {
    /**
     * This function is basically used for Calling function from IO Thread and
     * return to the Main Thread
     * ioToMainThread() is a Generic function and it will take 2 parameter
     * A : work -> this is a suspended function
     * B : callback -> which will take return data from
     *                 work function and return the caller
     */
    fun <T : Any> ioThenMain(work: suspend (() -> T?), callback: (T?) -> Unit) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }
}