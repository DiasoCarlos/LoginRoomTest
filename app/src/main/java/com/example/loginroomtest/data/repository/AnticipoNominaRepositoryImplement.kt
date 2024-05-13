package com.example.loginroomtest.data.repository

import com.example.loginroomtest.core.AppConstants.Companion.API_KEY
import com.example.loginroomtest.data.remote.AnticipoNominaApis
import com.example.loginroomtest.domain.valida_rfc.model.ValidaRFCRequest
import com.example.loginroomtest.domain.valida_rfc.model.ValidaRFCResponse
import com.example.loginroomtest.domain.valida_rfc.repository.AnticipoNominaApisRepository
import retrofit2.Response
import javax.inject.Inject

class AnticipoNominaRepositoryImplement @Inject constructor(
    private val anticipoNominaApis: AnticipoNominaApis
) : AnticipoNominaApisRepository{

    override suspend fun validaRFC(request: ValidaRFCRequest): Response<ValidaRFCResponse> {
        return anticipoNominaApis.validaRFC(request = request)
    }


}