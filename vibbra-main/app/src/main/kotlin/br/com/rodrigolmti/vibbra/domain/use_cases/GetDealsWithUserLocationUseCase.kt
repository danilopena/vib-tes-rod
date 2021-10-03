package br.com.rodrigolmti.vibbra.domain.use_cases

import br.com.rodrigolmti.vibbra.core.Result
import br.com.rodrigolmti.vibbra.domain.model.Deal
import br.com.rodrigolmti.vibbra.domain.repository.Repository
import javax.inject.Inject

interface GetDealsWithUserLocationUseCase {
    suspend operator fun invoke(latitude: Double, longitude: Double): Result<List<Deal>, Unit>
}

class GetDealsWithUserLocation @Inject constructor(
    private val repository: Repository
) : GetDealsWithUserLocationUseCase {

    override suspend fun invoke(
        latitude: Double, longitude: Double
    ): Result<List<Deal>, Unit> =
        repository.getDealsByLocation(latitude, longitude)
}