package br.com.luquinhas.loja.service

import br.com.luquinhas.loja.dto.UsuarioForm
import br.com.luquinhas.loja.dto.UsuarioView
import br.com.luquinhas.loja.mapper.UsuarioFormMapper
import br.com.luquinhas.loja.mapper.UsuarioViewMapper
import br.com.luquinhas.loja.model.UsuarioLogado
import br.com.luquinhas.loja.repository.UsuarioRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val mapperForm: UsuarioFormMapper,
    private val mapperView: UsuarioViewMapper
    ):UserDetailsService {
    fun cadastrar(usuarioForm: UsuarioForm): UsuarioView {
        val product = mapperForm.map(usuarioForm)
        repository.save(product)
        return mapperView.map(product)
    }
    override fun loadUserByUsername(email: String?): UserDetails {
        val data = repository.findByEmail(email) ?: throw RuntimeException()
        return UsuarioLogado(data)
    }

    fun busca(paginacao: Pageable): Page<UsuarioView> {
        val usuarios = repository.findAll(paginacao)
        return usuarios.map { user -> mapperView.map(user) }
    }
}