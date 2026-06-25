package com.example.composeapp.ui.productDetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeapp.R
import com.example.composeapp.ui.components.CommonTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    onBackClick: () -> Unit,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    val product = viewModel.product.value

    Scaffold(
        topBar = {
            CommonTopAppBar(
                title = stringResource(R.string.product_details_title),
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->
        product?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = it.title, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(16.dp))
                
                DetailItem(label = stringResource(R.string.label_description), value = it.description)
                DetailItem(label = stringResource(R.string.label_category), value = it.category)
                DetailItem(label = stringResource(R.string.label_price), value = "$${it.price}")
                DetailItem(label = stringResource(R.string.label_discount), value = "%${it.discountPercentage}")
                DetailItem(label = stringResource(R.string.label_rating), value = it.rating.toString())
                DetailItem(label = stringResource(R.string.label_stock), value = it.stock.toString())
                DetailItem(label = stringResource(R.string.label_tags), value = it.tags.joinToString(", "))
                DetailItem(label = stringResource(R.string.label_brand), value = it.brand ?: stringResource(R.string.not_available))
            }
        } ?: Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(R.string.loading_or_not_found))
        }
    }
}

@Composable
fun DetailItem(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = "$label:", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
    }
}
