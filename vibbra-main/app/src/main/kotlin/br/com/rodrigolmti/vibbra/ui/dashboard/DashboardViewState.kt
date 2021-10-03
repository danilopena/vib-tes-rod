package br.com.rodrigolmti.vibbra.ui.dashboard

import androidx.lifecycle.MutableLiveData
import br.com.rodrigolmti.vibbra.core.SingleLiveEvent
import br.com.rodrigolmti.vibbra.domain.model.Deal
import javax.inject.Inject

internal class DashboardViewState @Inject constructor() {

    val action: SingleLiveEvent<Action> = SingleLiveEvent()
    val state: MutableLiveData<State> = MutableLiveData()

    enum class State { IDLE, LOADING }

    sealed class Action {
        data class RenderDealsList(val deals: List<Deal>) : Action()
        object ShowError: Action()
    }
}