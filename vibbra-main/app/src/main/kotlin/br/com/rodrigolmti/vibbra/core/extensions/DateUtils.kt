package br.com.rodrigolmti.vibbra.core.extensions

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(pattern: String, date: Date): String {
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return simpleDateFormat.format(date)
}