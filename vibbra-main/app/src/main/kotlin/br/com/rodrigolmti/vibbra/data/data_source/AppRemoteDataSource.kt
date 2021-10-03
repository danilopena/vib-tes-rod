package br.com.rodrigolmti.vibbra.data.data_source

import br.com.rodrigolmti.vibbra.core.Result
import br.com.rodrigolmti.vibbra.data.factory.MockDataFactory
import br.com.rodrigolmti.vibbra.data.service.AppServiceAPI
import br.com.rodrigolmti.vibbra.domain.model.*
import br.com.rodrigolmti.vibbra.session.AppSession
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class AppRemoteDataSource @Inject constructor(
    private val appSession: AppSession,
    private val service: AppServiceAPI,
) : RemoteDataSource {

    override suspend fun doLogin(login: String, password: String): Result<User, Unit> =
        withContext(Dispatchers.IO) {
            return@withContext try {

                delay(2000)

                // Returning mocked data TODO: Implement the real service here
                // service.authenticateWithLogin ...

                Result.Success(MockDataFactory.fakeUser)

            } catch (error: Exception) {
                Result.Error(Unit)
            }
        }

    override suspend fun doSSOLogin(login: String, appToken: String): Result<User, Unit> =
        withContext(Dispatchers.IO) {
            return@withContext try {

                delay(2000)

                // Returning mocked data TODO: Implement the real service here
                // service.authenticateWithSSO ...

                Result.Success(MockDataFactory.fakeUser)

            } catch (error: Exception) {
                Result.Error(Unit)
            }
        }

    override suspend fun getAllDeals(): Result<List<Deal>, Unit> =
        withContext(Dispatchers.IO) {
            return@withContext try {

                delay(2000)

                val token = appSession.user?.token

                // Returning mocked data TODO: Implement the real service here
                // service.getAllDeals ...

                Result.Success(MockDataFactory.fakeDeals)

            } catch (error: Exception) {
                Result.Error(Unit)
            }
        }

    override suspend fun getDealsByLocation(
        latitude: Double,
        longitude: Double
    ): Result<List<Deal>, Unit> =
        withContext(Dispatchers.IO) {
            return@withContext try {

                delay(2000)

                val token = appSession.user?.token

                // Returning mocked data TODO: Implement the real service here
                // service.getDealsByLocation ...

                Result.Success(MockDataFactory.fakeDeals)

            } catch (error: Exception) {
                Result.Error(Unit)
            }
        }
}