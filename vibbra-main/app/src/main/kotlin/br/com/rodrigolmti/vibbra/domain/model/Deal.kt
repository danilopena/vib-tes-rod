package br.com.rodrigolmti.vibbra.domain.model

import br.com.rodrigolmti.vibbra.core.extensions.formatDate
import java.util.*

enum class DealType {
    sell, trade, desire
}

enum class DealUrgency {
    low, medium, high, date
}

data class Deal(
    val type: DealType,
    val value: Double,
    val description: String,
    val tradingFor: String,
    val location: Location,
    val urgency: DealUrgency,
    val limitDate: Date,
    val photos: List<String>
) {
    fun displayLimitDate() = formatDate("dd/MM/yyy", limitDate)
}
