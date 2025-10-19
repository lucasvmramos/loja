package br.com.luquinhas.loja.controller

import br.com.luquinhas.loja.model.Categoria
import br.com.luquinhas.loja.service.CategoriaService
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = ["http://localhost:4200","https://lucasvmramos.github.io"])
class BuscarCategorias(private val categoriaService: CategoriaService) {

    @GetMapping
    @Cacheable("categorias")
    fun buscarCategorias(): List<Categoria> {
        return this.categoriaService.buscarCategorias()
    }
}