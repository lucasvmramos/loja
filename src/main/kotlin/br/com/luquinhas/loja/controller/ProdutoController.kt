package br.com.luquinhas.loja.controller

import br.com.luquinhas.loja.dto.ProdutoForm
import br.com.luquinhas.loja.dto.ProdutoView
import br.com.luquinhas.loja.service.ProdutoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = ["http://localhost:4200", "https://lucasvmramos.github.io"])
class ProdutoController(
    private val service: ProdutoService,
) {
    @PostMapping("/cadastrar")
    fun cadastrarProduto(
        @Valid
        @RequestBody form: ProdutoForm,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<ProdutoView> {

        val view = service.cadastrarProduto(form)
        val uri = uriBuilder.path("/produto/${view.id}").build().toUri()
        return ResponseEntity.created(uri).body(view)
    }

    @GetMapping("/{id}")
    fun buscarProdutoPorID(@PathVariable id: Long): ProdutoView {
        return this.service.buscarPorID(id)
    }

    @GetMapping
    fun buscarTodosProdutos(
        @RequestParam(required = false) nomeCategoria: String?,
    ): List<ProdutoView> {
        return service.buscarTodos(nomeCategoria)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.removerProduto(id)
    }
}