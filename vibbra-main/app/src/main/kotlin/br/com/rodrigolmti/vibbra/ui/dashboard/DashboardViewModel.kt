package br.com.rodrigolmti.vibbra.ui.dashboard

import androidx.lifecycle.viewModelScope
import br.com.rodrigolmti.vibbra.core.BaseViewModel
import br.com.rodrigolmti.vibbra.domain.use_cases.GetAllDealsUseCase
import br.com.rodrigolmti.vibbra.domain.use_cases.GetDealsWithUserLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DashboardViewModel @Inject constructor(
    override val viewState: DashboardViewState,
    private val getAllDealsUseCase: GetAllDealsUseCase,
    private val getDealsWithUserLocation: GetDealsWithUserLocation
) : BaseViewModel<DashboardViewState, DashboardAction>() {

    init {
        viewState.state.value = DashboardViewState.State.LOADING
    }

    override fun dispatchViewAction(viewAction: DashboardAction) {
        when(viewAction) {
            is DashboardAction.GetAllDeals -> {
                getAllDeals()
            }
            is DashboardAction.GetDealsWithLatLong -> {
                getDealsByLatLong(viewAction.latitude, viewAction.longitude)
            }
        }
    }

    private fun getAllDeals() {
        viewModelScope.launch {

            viewState.state.value = DashboardViewState.State.LOADING

            getAllDealsUseCase().handleResult(
                onSuccess = {
                    viewState.action.value = DashboardViewState.Action.RenderDealsList(it)
                },
                onError = {
                    viewState.action.value = DashboardViewState.Action.ShowError
                },
                onFinish = {
                    viewState.state.value = DashboardViewState.State.IDLE
                }
            )
        }
    }

    private fun getDealsByLatLong(latitude: Double, longitude: Double) {
        viewModelScope.launch {

            viewState.state.value = DashboardViewState.State.LOADING

            getDealsWithUserLocation(latitude, longitude).handleResult(
                onSuccess = {
                    viewState.action.value = DashboardViewState.Action.RenderDealsList(it)
                },
                onError = {
                    viewState.action.value = DashboardViewState.Action.ShowError
                },
                onFinish = {
                    viewState.state.value = DashboardViewState.State.IDLE
                }
            )
        }
    }
}