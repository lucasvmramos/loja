package br.com.luquinhas.loja.controller

import br.com.luquinhas.loja.model.Categoria
import br.com.luquinhas.loja.service.CategoriaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = ["http://localhost:4200","https://lucasvmramos.github.io"])
class CategoriaController(private val categoriaService: CategoriaService) {

    @PostMapping("/cadastrar")
    fun cadastrarCategoria(
        @RequestBody categoria: Categoria,
        uriBuilder: UriComponentsBuilder,
    ): ResponseEntity<Categoria> {
        val cadastro = this.categoriaService.cadastrarCategoria(categoria)
        val uri = uriBuilder.path("/categoria/${cadastro.id}").build().toUri()
        return ResponseEntity.created(uri).body(cadastro)
    }

    @GetMapping
    fun buscarCategorias(): List<Categoria> {
        return this.categoriaService.buscarCategorias()
    }

    @GetMapping("/{id}")
    fun buscarPorID(@PathVariable id:Long):Categoria{
        return this.categoriaService.buscarCategoriaPorID(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletarCategoria(@PathVariable id:Long){
        this.categoriaService.deletarCategoria(id)
    }
}