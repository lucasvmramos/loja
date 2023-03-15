package br.com.luquinhas.loja.dto

import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class ProdutoForm (

    @field:NotEmpty
    @field:Size(min=3, max = 20)
    val nome:String,
    @field:NotEmpty
    val descricao:String,
    @field:NotNull
    val valor:BigDecimal,
    @field:NotNull
    val categoria:Long
)