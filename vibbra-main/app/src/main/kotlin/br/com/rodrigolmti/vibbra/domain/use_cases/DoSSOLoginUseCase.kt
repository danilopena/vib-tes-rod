package br.com.rodrigolmti.vibbra.domain.use_cases

import br.com.rodrigolmti.vibbra.core.Result
import br.com.rodrigolmti.vibbra.domain.model.User
import br.com.rodrigolmti.vibbra.domain.repository.Repository
import javax.inject.Inject

interface DoSSOLoginUseCase {
    suspend operator fun invoke(
        login: String,
        appToken: String,
    ): Result<User, Unit>
}

class DoSSOLogin @Inject constructor(
    private val repository: Repository
) : DoSSOLoginUseCase {

    override suspend fun invoke(
        login: String,
        appToken: String,
    ): Result<User, Unit> =
        repository.doSSOLogin(login, appToken)
}