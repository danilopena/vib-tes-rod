package br.com.rodrigolmti.vibbra.domain.model

data class User(
    val token: String,
    val name: String,
    val email: String,
    val login: String,
    val location: Location
)

