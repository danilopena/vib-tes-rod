package br.com.rodrigolmti.vibbra.data.repository

import br.com.rodrigolmti.vibbra.core.Result
import br.com.rodrigolmti.vibbra.data.data_source.RemoteDataSource
import br.com.rodrigolmti.vibbra.domain.model.Deal
import br.com.rodrigolmti.vibbra.domain.model.User
import br.com.rodrigolmti.vibbra.domain.repository.Repository
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override suspend fun doLogin(login: String, password: String): Result<User, Unit> =
        remoteDataSource.doLogin(login, password)

    override suspend fun doSSOLogin(login: String, appToken: String): Result<User, Unit> =
        remoteDataSource.doSSOLogin(login, appToken)

    override suspend fun getAllDeals(): Result<List<Deal>, Unit> = remoteDataSource.getAllDeals()

    override suspend fun getDealsByLocation(
        latitude: Double,
        longitude: Double
    ): Result<List<Deal>, Unit> = remoteDataSource.getDealsByLocation(latitude, longitude)
}