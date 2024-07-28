package br.com.luquinhas.loja.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*


@Entity
class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val dataCadastro: LocalDateTime? = LocalDateTime.now(),
    var nome: String,
    var email: String,
    var senha: String,

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_rule",
        joinColumns = [JoinColumn(name = "usuario_id")],
        inverseJoinColumns = [JoinColumn(name = "rule_id")]
    )
    var rules: List<Rule> = mutableListOf()
)