package br.com.luquinhas.loja.service

import br.com.luquinhas.loja.model.Usuario
import br.com.luquinhas.loja.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val repository: UsuarioRepository):UserDetailsService{

    fun buscaPorId(id:Long):Usuario{
        return repository.getReferenceById(id)
    }

    override fun loadUserByUsername(username: String?): UserDetail {
        val usuario = repository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(usuario)
    }
}