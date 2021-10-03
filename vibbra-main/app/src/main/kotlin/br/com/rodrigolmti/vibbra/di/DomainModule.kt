package br.com.rodrigolmti.vibbra.di

import br.com.rodrigolmti.vibbra.data.repository.AppRepository
import br.com.rodrigolmti.vibbra.domain.repository.Repository
import br.com.rodrigolmti.vibbra.domain.use_cases.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindDoLoginUseCase(
        doLogin: DoLogin
    ): DoLoginUseCase

    @Binds
    abstract fun bindDoSSOLoginUseCase(
        doSSOLogin: DoSSOLogin
    ): DoSSOLoginUseCase

    @Binds
    abstract fun bindGetAllDealsUseCase(
        getAllDeals: GetAllDeals
    ): GetAllDealsUseCase

    @Binds
    abstract fun bindGetDealsWithUserLocationUseCase(
        getDealsWithUserLocation: GetDealsWithUserLocation
    ): GetDealsWithUserLocationUseCase

    @Binds
    abstract fun bindRepository(
        appRepository: AppRepository
    ): Repository
}