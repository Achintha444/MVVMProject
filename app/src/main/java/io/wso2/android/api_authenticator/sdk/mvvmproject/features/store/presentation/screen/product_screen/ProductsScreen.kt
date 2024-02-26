package io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.presentation.screen.product_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.presentation.screen.product_screen.components.ProductCard
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.presentation.util.components.LoadingDialog

@Composable
internal fun ProductsScreen(
    viewModel: ProductViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    ProductContent(state.value)
}

@Composable
private fun ProductContent(
    state: ProductsViewState
) {
    LoadingDialog(state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { padding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(state.products.size) { index ->
                    ProductCard(product = state.products[index])
                }
            }
        }
    )
}
