package br.com.rodrigolmti.vibbra.data.service.response

import com.squareup.moshi.Json

data class AuthenticateResponse(
    @Json(name = "token")
    val token: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "login")
    val login: String,
    @Json(name = "location")
    val location: LocationResponse
)