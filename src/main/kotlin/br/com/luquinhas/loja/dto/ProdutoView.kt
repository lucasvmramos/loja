package br.com.luquinhas.loja.dto

import java.math.BigDecimal
import java.time.LocalDateTime

class ProdutoView(
    val dataCriacao: LocalDateTime?,
    val nome: String,
    val valor:BigDecimal
)