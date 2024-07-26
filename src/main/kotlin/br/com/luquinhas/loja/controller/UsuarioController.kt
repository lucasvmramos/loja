package br.com.luquinhas.loja.controller

import br.com.luquinhas.loja.dto.ProdutoView
import br.com.luquinhas.loja.dto.UsuarioForm
import br.com.luquinhas.loja.dto.UsuarioView
import br.com.luquinhas.loja.service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = ["http://localhost:4200", "https://lucasvmramos.github.io"])
class UsuarioController(
    private val service: UsuarioService
) {

    @PostMapping("/cadastrar")
    fun cadastra(
        @Valid
        @RequestBody usuariosForm: UsuarioForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<UsuarioView> {
        val view = service.cadastrar(usuariosForm)
        val uri = uriBuilder.path("/usuario/${view.id}").build().toUri()
        return ResponseEntity.created(uri).body(view)
    }
}