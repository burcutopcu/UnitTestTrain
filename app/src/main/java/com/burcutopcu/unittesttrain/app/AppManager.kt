package com.burcutopcu.unittesttrain.app

import com.burcutopcu.unittesttrain.constants.GeneralConstants
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class AppManager {

    private var retrofit: Retrofit? = null
    private var client = OkHttpClient.Builder()

    private fun init() {
        client.addNetworkInterceptor(StethoInterceptor())
        client.addInterceptor(RequestInterceptor())
    }

    fun <S> createRetrofitService(serviceClass: Class<S>): S {
        return getRetrofit().create(serviceClass)
    }

    private fun getRetrofit(): Retrofit {

        if (retrofit == null) {
            init()
            retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .baseUrl(GeneralConstants.BASE_URL)
                .build()

        }
        return retrofit!!
    }


    private class RequestInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain?): Response {

            val newRequestBuilder = chain?.request()?.newBuilder()
            newRequestBuilder?.addHeader(GeneralConstants.CONTENT_TYPE, GeneralConstants.JSON)

            val request = newRequestBuilder?.build()
            val response = chain?.proceed(request!!)

            return response!!
        }

    }
}