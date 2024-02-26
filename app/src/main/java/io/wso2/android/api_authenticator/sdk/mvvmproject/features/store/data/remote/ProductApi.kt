package io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.data.remote

import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.model.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("/products")
    suspend fun getProducts(): List<Product>
}