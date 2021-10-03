package br.com.rodrigolmti.vibbra.core

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State, Action> : ViewModel() {

    abstract val viewState: State
    abstract fun dispatchViewAction(viewAction: Action)
}