package br.com.rodrigolmti.vibbra.ui.authentication

internal sealed class SignInAction {
    data class DoLogin(
        val login: String,
        val password: String
    ) : SignInAction()

    data class DoSSOLogin(
        val login: String,
        val appToken: String
    ) : SignInAction()
}