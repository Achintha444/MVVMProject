package io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.presentation.screen.product_screen

import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.model.Product

data class ProductsViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
