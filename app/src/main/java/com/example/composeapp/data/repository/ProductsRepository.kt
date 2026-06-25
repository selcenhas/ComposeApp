package com.example.composeapp.data.repository

import android.util.Log
import com.example.composeapp.data.local.ProductDao
import com.example.composeapp.data.remote.ApiService
import com.example.composeapp.data.models.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val apiService: ApiService,
    private val productDao: ProductDao
) {
    val products: Flow<List<Product>> = productDao.getAllProducts()

    suspend fun getProductById(id: Int): Product? = productDao.getProductById(id)

    suspend fun refreshProducts() {
        try {
            val response = apiService.getProducts()
            productDao.insertProducts(response.products)
        } catch (e: Exception) {
            Log.e(this::class.java.simpleName, "Error refreshing products: ${e.message}", e)
        }
    }
}
