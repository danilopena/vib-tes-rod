package br.com.rodrigolmti.vibbra.domain.use_cases

import br.com.rodrigolmti.vibbra.core.Result
import br.com.rodrigolmti.vibbra.domain.model.User
import br.com.rodrigolmti.vibbra.domain.repository.Repository
import javax.inject.Inject

interface DoLoginUseCase {
    suspend operator fun invoke(
        login: String,
        password: String,
    ): Result<User, Unit>
}

class DoLogin @Inject constructor(
    private val repository: Repository,
) : DoLoginUseCase {

    override suspend fun invoke(
        login: String,
        password: String,
    ): Result<User, Unit> =
        repository.doLogin(login, password)
}