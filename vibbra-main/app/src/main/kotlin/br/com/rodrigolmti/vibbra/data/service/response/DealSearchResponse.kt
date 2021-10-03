package br.com.rodrigolmti.vibbra.data.service.response

import br.com.rodrigolmti.vibbra.domain.model.DealType
import br.com.rodrigolmti.vibbra.domain.model.DealUrgency
import br.com.rodrigolmti.vibbra.domain.model.Location
import com.squareup.moshi.Json
import java.util.*

class DealSearchDataResponse constructor(
    @Json(name = "deal")
    val deal: DealSearchResponse
)

class DealSearchResponse constructor(
    @Json(name = "type")
    val type: DealType,
    @Json(name = "value")
    val value: Double,
    @Json(name = "description")
    val description: String,
    @Json(name = "trading_for")
    val tradingFor: String,
    @Json(name = "location")
    val location: Location,
    @Json(name = "urgency")
    val urgency: DealUrgency,
    @Json(name = "limit_date")
    val limitDate: Date,
    @Json(name = "photos")
    val photos: List<DealPhotoResponse>
)

class DealPhotoResponse constructor(
    @Json(name = "src")
    val src: String
)