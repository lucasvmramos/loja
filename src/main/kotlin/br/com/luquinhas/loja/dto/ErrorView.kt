package br.com.luquinhas.loja.dto

import java.time.LocalDateTime

data class ErrorView (
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val error:String,
    val status:Int,
    val mensagem:String?,
    val path:String
)
