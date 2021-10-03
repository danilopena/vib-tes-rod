package br.com.rodrigolmti.vibbra.data.service.payload

import com.squareup.moshi.Json

data class AuthenticateBody constructor(
    @Json(name = "login")
    val login: String,
    @Json(name = "password")
    val password: String
)

data class AuthenticateSSOBody constructor(
    @Json(name = "login")
    val login: String,
    @Json(name = "app_token")
    val appToken: String
)