package io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.data.impl.mapper


import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.model.error.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when (this) {
        is IOException -> NetworkError.ApiError.NetworkError
        is HttpException -> NetworkError.ApiError.UnknownResponse
        else -> NetworkError.ApiError.UnknownError
    }

    return NetworkError(error, this)
}
