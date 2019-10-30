package com.burcutopcu.unittesttrain.app

interface IServiceResponseCallback<T> {

    fun onServerError(error: String?)

    fun onServerCompleted(t:T)

    fun onServerCompleted()
}