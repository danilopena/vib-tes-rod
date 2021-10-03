package br.com.rodrigolmti.vibbra.ui.authentication

import androidx.lifecycle.viewModelScope
import br.com.rodrigolmti.vibbra.core.BaseViewModel
import br.com.rodrigolmti.vibbra.domain.use_cases.DoLoginUseCase
import br.com.rodrigolmti.vibbra.domain.use_cases.DoSSOLoginUseCase
import br.com.rodrigolmti.vibbra.session.AppSession
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SignInViewModel @Inject constructor(
    override val viewState: SignInViewState,
    private val ssoLoginUseCase: DoSSOLoginUseCase,
    private val loginUseCase: DoLoginUseCase,
    private val appSession: AppSession,
) : BaseViewModel<SignInViewState, SignInAction>() {

    override fun dispatchViewAction(viewAction: SignInAction) {
        when (viewAction) {
            is SignInAction.DoLogin -> {
                doLogin(viewAction)
            }
            is SignInAction.DoSSOLogin -> {
                doSSOLogin(viewAction)
            }
        }
    }

    private fun doLogin(viewAction: SignInAction.DoLogin) {
        viewModelScope.launch {

            if (viewAction.login.isEmpty()) {
                viewState.action.value = SignInViewState.Action.InvalidLogin
                return@launch
            }

            if (viewAction.password.isEmpty()) {
                viewState.action.value = SignInViewState.Action.InvalidPassword
                return@launch
            }

            viewState.action.value = SignInViewState.Action.ResetFieldError
            viewState.state.value = SignInViewState.State.LOADING

            loginUseCase(
                viewAction.login,
                viewAction.password
            ).handleResult(
                onSuccess = {
                    appSession.user = it
                    viewState.action.value = SignInViewState.Action.SuccessLogin
                },
                onError = {
                    viewState.action.value = SignInViewState.Action.ShowError
                },
                onFinish = {
                    viewState.state.value = SignInViewState.State.IDLE
                }
            )
        }
    }

    private fun doSSOLogin(viewAction: SignInAction.DoSSOLogin) {
        viewModelScope.launch {

            viewState.state.value = SignInViewState.State.LOADING

            ssoLoginUseCase(
                viewAction.login,
                viewAction.appToken
            ).handleResult(
                onSuccess = {
                    appSession.user = it
                    viewState.action.value = SignInViewState.Action.SuccessLogin
                },
                onError = {
                    viewState.action.value = SignInViewState.Action.ShowError
                },
                onFinish = {
                    viewState.state.value = SignInViewState.State.IDLE
                }
            )
        }
    }
}