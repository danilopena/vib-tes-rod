package br.com.rodrigolmti.vibbra.data.service.response

import com.squareup.moshi.Json

data class LocationResponse(
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "longitude")
    val longitude: Double,
    @Json(name = "address")
    val address: String,
    @Json(name = "city")
    val city: String,
    @Json(name = "state")
    val state: String,
    @Json(name = "zip_code")
    val zipCode: Int
)