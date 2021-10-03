package br.com.rodrigolmti.vibbra.ui.dashboard

internal sealed class DashboardAction {
    object GetAllDeals : DashboardAction()
    data class GetDealsWithLatLong(val latitude: Double, val longitude: Double) : DashboardAction()
}