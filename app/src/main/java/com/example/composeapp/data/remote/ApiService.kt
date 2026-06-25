package com.example.composeapp.data.remote

import com.example.composeapp.data.models.ProductResponse
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}
