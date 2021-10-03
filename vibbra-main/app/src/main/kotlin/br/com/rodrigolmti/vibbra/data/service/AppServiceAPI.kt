package br.com.rodrigolmti.vibbra.data.service

import br.com.rodrigolmti.vibbra.data.service.payload.AuthenticateBody
import br.com.rodrigolmti.vibbra.data.service.payload.AuthenticateSSOBody
import br.com.rodrigolmti.vibbra.data.service.payload.DealSearchBody
import br.com.rodrigolmti.vibbra.data.service.response.AuthenticateResponse
import br.com.rodrigolmti.vibbra.data.service.response.DealSearchDataResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AppServiceAPI {

    @POST("authenticate/")
    suspend fun authenticateWithLogin(
        @Body body: AuthenticateBody,
    ): AuthenticateResponse

    @POST("authenticate/sso")
    suspend fun authenticateWithSSO(
        @Body body: AuthenticateSSOBody,
    ): AuthenticateResponse

    @POST("deal/search")
    suspend fun getAllDeals(
        @Body body: DealSearchBody,
        @Header("authorization") authorization: String,
    ): DealSearchDataResponse

    @POST("deal/search")
    suspend fun getDealsByLocation(
        @Body body: DealSearchBody,
        @Header("authorization") authorization: String,
    ): DealSearchDataResponse
}

