package com.example.loginroomtest.domain.valida_rfc.repository

import com.example.loginroomtest.domain.valida_rfc.model.ValidaRFCRequest
import com.example.loginroomtest.domain.valida_rfc.model.ValidaRFCResponse
import retrofit2.Response

interface AnticipoNominaApisRepository {

    suspend fun validaRFC(request : ValidaRFCRequest) : Response<ValidaRFCResponse>

}