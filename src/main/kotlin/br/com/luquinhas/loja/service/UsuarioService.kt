package br.com.luquinhas.loja.service

import br.com.luquinhas.loja.dto.ProdutoForm
import br.com.luquinhas.loja.dto.ProdutoView
import br.com.luquinhas.loja.dto.UsuarioForm
import br.com.luquinhas.loja.dto.UsuarioView
import br.com.luquinhas.loja.mapper.UsuarioFormMapper
import br.com.luquinhas.loja.mapper.UsuarioViewMapper
import br.com.luquinhas.loja.repository.UsuarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val mapperForm: UsuarioFormMapper,
    private val mapperView: UsuarioViewMapper
    ) {
    fun cadastrar(usuarioForm: UsuarioForm): UsuarioView {
        val product = mapperForm.map(usuarioForm)
        repository.save(product)
        return mapperView.map(product)
    }
}