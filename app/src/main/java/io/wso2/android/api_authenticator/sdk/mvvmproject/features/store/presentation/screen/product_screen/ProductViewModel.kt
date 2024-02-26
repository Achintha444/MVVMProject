package io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.presentation.screen.product_screen

import androidx.lifecycle.ViewModel
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import dagger.hilt.android.lifecycle.HiltViewModel
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.model.Product
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.model.error.NetworkError
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.presentation.util.sendEvent
import io.wso2.android.api_authenticator.sdk.mvvmproject.util.Event
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel() {
    private val _state = MutableStateFlow(ProductsViewState())
    val state = _state.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            val result: Either<NetworkError, List<Product>> = productRepository.getProducts()
            result.fold(
                ifLeft = { error ->
                    _state.update {
                        it.copy(error = error.error.error)
                    }
                    sendEvent(Event.Toast(error.error.error))
                },
                ifRight = { products ->
                    _state.update {
                        it.copy(products = products)
                    }
                }
            )
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}