package io.henrikhorbovyi.data.common

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val token: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.run {
            val modifiedUrl = request()
                .url
                .toUrl()
                .toExternalForm()
                .plus(token)

            val request = request()
                .newBuilder()
                .url(modifiedUrl)
                .build()
            proceed(request)
        }
    }
}