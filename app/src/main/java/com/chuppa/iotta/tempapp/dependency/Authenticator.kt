package com.chuppa.iotta.tempapp.dependency

import okhttp3.Interceptor
import okhttp3.Response
class Authenticator : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()
        return chain.proceed(request)
    }

}
