package com.example.composeapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class RetryInterceptor(private val maxRetries: Int = 3) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var response = chain.proceed(request)
        var attempt = 0

        while ((!response.isSuccessful) && attempt < maxRetries && response.code() >= 500) {
            attempt++
            response.close()
            try {
                Thread.sleep(1000L * attempt)
            } catch (_: InterruptedException) {
                Thread.currentThread().interrupt()
                break
            }
            response = chain.proceed(request)
        }
        return response
    }
}
