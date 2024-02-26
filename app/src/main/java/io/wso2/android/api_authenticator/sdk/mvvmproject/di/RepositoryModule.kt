package io.wso2.android.api_authenticator.sdk.mvvmproject.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.data.impl.repository.ProductRepositoryImpl
import io.wso2.android.api_authenticator.sdk.mvvmproject.features.store.domain.repository.ProductRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(productRepository: ProductRepositoryImpl): ProductRepository
}
