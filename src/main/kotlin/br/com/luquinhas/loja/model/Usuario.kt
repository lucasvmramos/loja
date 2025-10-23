package br.com.luquinhas.loja.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String,
    val senha: String,

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rule",
        joinColumns = [JoinColumn(name="usuario_id")],
        inverseJoinColumns = [JoinColumn(name = "rule_id")]
        )
    val role:List<Rule> = mutableListOf()
)
