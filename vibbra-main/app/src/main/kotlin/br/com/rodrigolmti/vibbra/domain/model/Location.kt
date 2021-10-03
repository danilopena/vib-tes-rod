package br.com.rodrigolmti.vibbra.domain.model

data class Location(
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val city: String,
    val state: String,
    val zipCode: Int
)