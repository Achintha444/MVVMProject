package io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.wso2.android.api_authenticator.sdk.mvvmproject.util.Event
import io.wso2.android.api_authenticator.sdk.mvvmproject.util.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvent(event: Event) {
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}