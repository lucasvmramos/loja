package br.com.luquinhas.loja.controller

import br.com.luquinhas.loja.dto.AtualizarProdutoForm
import br.com.luquinhas.loja.dto.ProdutoForm
import br.com.luquinhas.loja.dto.ProdutoView
import br.com.luquinhas.loja.service.ProdutoService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
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
    @Transactional
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
        paginacao: Pageable,
    ): Page<ProdutoView> {
        return service.buscarTodos(nomeCategoria, paginacao)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.removerProduto(id)
    }

    @PutMapping
    @Transactional
    fun atualizar(@RequestBody form: AtualizarProdutoForm): ProdutoView {
        return service.atualizar(form)
    }
}