package br.com.luquinhas.loja.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Usuario(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val dataCadastro: LocalDateTime? = LocalDateTime.now(),
        var nome: String,
        var email:String,
        var senha:String
)