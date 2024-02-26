package io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.repository

import arrow.core.Either
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.model.Product
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.model.error.NetworkError

interface ProductRepository {
    suspend fun getProducts(): Either<NetworkError, List<Product>>
}