package io.henrikhorbovyi.data.common

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ServiceBuilder {

    companion object {
        inline operator fun <reified S> invoke(baseUrl: String, token: String = ""): S {
            val httpClient = buildInterceptors(token)
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
                .create(S::class.java)
        }

        fun buildInterceptors(token: String): OkHttpClient {
            val loggerInterceptor = getLoggerInterceptor()
            val authInterceptor = AuthInterceptor(token)
            return OkHttpClient.Builder().apply {
                addInterceptor(authInterceptor)
                addInterceptor(loggerInterceptor)
            }.build()
        }

        private fun getLoggerInterceptor(): HttpLoggingInterceptor {
            /*val level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE*/
            return HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }
        }
    }
}