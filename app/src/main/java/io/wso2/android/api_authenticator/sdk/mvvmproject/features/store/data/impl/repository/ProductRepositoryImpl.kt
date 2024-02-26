package io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.data.impl.repository

import arrow.core.Either
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.data.impl.mapper.toNetworkError
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.data.remote.ProductApi
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.model.Product
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.model.error.NetworkError
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productApi: ProductApi
): ProductRepository {

    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
       return Either.catch {
            productApi.getProducts()
        }.mapLeft {
            it.toNetworkError()
        }
    }
}
