package br.com.rodrigolmti.vibbra.session

import br.com.rodrigolmti.vibbra.domain.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppSession @Inject constructor() {

    var user: User? = null
}