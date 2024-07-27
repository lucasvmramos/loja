package br.com.luquinhas.loja.repository

import br.com.luquinhas.loja.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {
    fun findByEmail(email: String?): Usuario?
}