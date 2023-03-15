package br.com.luquinhas.loja.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var nome: String,
    var descricao: String,
    val dataCadastro: LocalDateTime? = LocalDateTime.now(),
    var valor: BigDecimal,
    @ManyToOne
    val categoria: Categoria,
) {
}