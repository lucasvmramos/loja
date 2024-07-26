package br.com.luquinhas.loja.dto

import java.math.BigDecimal
import java.time.LocalDateTime

class UsuarioView (
        val id: Long?,
        val dataCriacao: LocalDateTime?,
        val nome: String
)