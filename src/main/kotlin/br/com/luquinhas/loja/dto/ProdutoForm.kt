package br.com.luquinhas.loja.dto

import java.math.BigDecimal

data class ProdutoForm (
    val nome:String,
    val descricao:String,
    val valor:BigDecimal,
    val categoria:Long
)