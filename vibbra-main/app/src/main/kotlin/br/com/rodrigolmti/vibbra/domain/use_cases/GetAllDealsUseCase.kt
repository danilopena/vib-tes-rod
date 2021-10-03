package br.com.rodrigolmti.vibbra.domain.use_cases

import br.com.rodrigolmti.vibbra.core.Result
import br.com.rodrigolmti.vibbra.domain.model.Deal
import br.com.rodrigolmti.vibbra.domain.repository.Repository
import javax.inject.Inject

interface GetAllDealsUseCase {
    suspend operator fun invoke(): Result<List<Deal>, Unit>
}

class GetAllDeals @Inject constructor(
    private val repository: Repository
) : GetAllDealsUseCase {

    override suspend fun invoke(
    ): Result<List<Deal>, Unit> =
        repository.getAllDeals()
}