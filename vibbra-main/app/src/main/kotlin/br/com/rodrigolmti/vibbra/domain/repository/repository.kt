package br.com.rodrigolmti.vibbra.domain.repository

import br.com.rodrigolmti.vibbra.core.Result
import br.com.rodrigolmti.vibbra.domain.model.Deal
import br.com.rodrigolmti.vibbra.domain.model.User

interface Repository {
    suspend fun doLogin(login: String, password: String): Result<User, Unit>

    suspend fun doSSOLogin(login: String, appToken: String): Result<User, Unit>

    suspend fun getAllDeals(): Result<List<Deal>, Unit>

    suspend fun getDealsByLocation(latitude: Double, longitude: Double): Result<List<Deal>, Unit>
}