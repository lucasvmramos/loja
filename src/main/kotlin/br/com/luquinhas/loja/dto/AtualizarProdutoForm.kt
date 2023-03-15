package br.com.luquinhas.loja.dto

import java.math.BigDecimal
import java.time.LocalDateTime

class AtualizarProdutoForm(
    val id: Long,
    val nome: String,
    val valor: BigDecimal,
)