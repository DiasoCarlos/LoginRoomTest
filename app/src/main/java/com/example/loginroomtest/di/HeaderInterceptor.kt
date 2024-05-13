package com.example.loginroomtest.di

import com.example.loginroomtest.core.AppConstants.Companion.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain
            .request()
            .newBuilder()
            .addHeader("api_key", API_KEY)
            .build()

        return chain.proceed(request)

    }

}