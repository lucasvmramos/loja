package br.com.luquinhas.loja.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class ProdutoView(
    val id: Long?,
    val dataCriacao: LocalDateTime?,
    val nome: String,
    val valor: BigDecimal
)