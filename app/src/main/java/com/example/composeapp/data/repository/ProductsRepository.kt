package com.example.composeapp.data.repository

import com.example.composeapp.data.local.ProductDao
import com.example.composeapp.data.models.Product
import com.example.composeapp.data.remote.ApiService
import com.example.composeapp.utils.retryWithBackoff
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepository @Inject constructor(
    private val apiService: ApiService,
    private val productDao: ProductDao
) {
    val products: Flow<List<Product>> = productDao.observeProducts()

    fun observeProducts(): Flow<List<Product>> = productDao.observeProducts()

    suspend fun getProductById(id: Int): Product? = productDao.getProductById(id)

    suspend fun refreshProducts(): Result<Unit> = runCatching {
        val remoteResponse = retryWithBackoff { apiService.getProducts() }
        productDao.upsertAll(remoteResponse.products)
    }
}
