package br.com.rodrigolmti.vibbra.di

import br.com.rodrigolmti.vibbra.data.data_source.AppRemoteDataSource
import br.com.rodrigolmti.vibbra.data.data_source.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindRemoteDataSource(
        appRemoteDataSource: AppRemoteDataSource
    ): RemoteDataSource
}