package com.example.composeapp.ui.productDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.data.models.Product
import com.example.composeapp.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productsRepository: ProductsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _product = mutableStateOf<Product?>(null)
    val product: State<Product?> = _product

    init {
        val productId = savedStateHandle.get<Int>("productId") ?: savedStateHandle.get<String>("productId")?.toIntOrNull()
        productId?.let { id ->
            getProduct(id)
        }
    }

    private fun getProduct(id: Int) {
        viewModelScope.launch {
            _product.value = productsRepository.getProductById(id)
        }
    }
}