package com.example.loginroomtest.data.remote

import com.example.loginroomtest.core.AppConstants.Companion.VALIDA_RFC_ENDPOINT
import com.example.loginroomtest.domain.valida_rfc.model.ValidaRFCRequest
import com.example.loginroomtest.domain.valida_rfc.model.ValidaRFCResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface AnticipoNominaApis {

    @POST(VALIDA_RFC_ENDPOINT)
    suspend fun validaRFC(@Body request : ValidaRFCRequest) : Response<ValidaRFCResponse>

}