package br.com.rodrigolmti.vibbra.ui.authentication

import androidx.lifecycle.MutableLiveData
import br.com.rodrigolmti.vibbra.core.SingleLiveEvent
import javax.inject.Inject

internal class SignInViewState @Inject constructor() {

    val action: SingleLiveEvent<Action> = SingleLiveEvent()
    val state: MutableLiveData<State> = MutableLiveData()

    enum class State { IDLE, LOADING }

    sealed class Action {
        object InvalidLogin : Action()
        object InvalidPassword : Action()
        object ResetFieldError : Action()
        object SuccessLogin : Action()
        object ShowError : Action()
    }
}