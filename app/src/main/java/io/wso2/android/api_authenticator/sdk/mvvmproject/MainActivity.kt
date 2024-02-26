package io.wso2.android.api_authenticator.sdk.mvvmproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.presentation.screen.product_screen.ProductsScreen
import io.wso2.android.api_authenticator.sdk.mvvmproject.ui.theme.MVVMProjectTheme
import io.wso2.android.api_authenticator.sdk.mvvmproject.util.Event
import io.wso2.android.api_authenticator.sdk.mvvmproject.util.EventBus

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMProjectTheme {
                val lifecycle = LocalLifecycleOwner.current.lifecycle
                LaunchedEffect(key1 = lifecycle) {
                    repeatOnLifecycle(Lifecycle.State.STARTED) {
                        EventBus.events.collect { event ->
                            when (event) {
                                is Event.Toast -> {
                                    // Show toast
                                    Toast.makeText(
                                        this@MainActivity,
                                        event.message,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    }
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(text = "Hello, MVVMProject!")
                    ProductsScreen()
                }
            }
        }
    }
}
