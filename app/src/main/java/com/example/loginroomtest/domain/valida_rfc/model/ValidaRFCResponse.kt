package com.example.loginroomtest.domain.valida_rfc.model

data class ValidaRFCResponse(
    val AMaterno: String?,
    val APaterno: String?,
    val EsCliente: Boolean,
    val Mensaje: String,
    val Nombre: String?,
    val Status: Int
)