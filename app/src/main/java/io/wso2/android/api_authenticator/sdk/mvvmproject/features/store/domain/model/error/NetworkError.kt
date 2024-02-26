package io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.model.error

data class NetworkError(
    val error: ApiError,
    val t: Throwable? = null
) {
    enum class ApiError(val error: String) {
        NetworkError("Network Error"),
        UnknownResponse("Unknown Response"),
        UnknownError("Unknown Error")
    }
}
