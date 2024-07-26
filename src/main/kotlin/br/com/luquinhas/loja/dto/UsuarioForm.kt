package br.com.luquinhas.loja.dto

import java.math.BigDecimal
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UsuarioForm (
        @field:NotEmpty
        @field:Size(min=1, max = 40)
        val nome:String,
        @field:NotEmpty
        @field:Email
        val email:String,
        @field:NotNull
        val senha: String
)