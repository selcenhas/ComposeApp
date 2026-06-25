package com.example.composeapp.ui.products

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.data.models.Product
import com.example.composeapp.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : ViewModel() {
    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> = _products

    init {
        observeProducts()
        refreshProducts()
    }

    private fun observeProducts() {
        viewModelScope.launch {
            productsRepository.products.collectLatest { productList ->
                _products.value = productList
            }
        }
    }

    private fun refreshProducts() {
        viewModelScope.launch {
            productsRepository.refreshProducts()
        }
    }
}
