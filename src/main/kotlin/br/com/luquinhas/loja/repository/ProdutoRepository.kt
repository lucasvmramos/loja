package br.com.luquinhas.loja.repository

import br.com.luquinhas.loja.model.Produto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository:JpaRepository<Produto,Long> {
    fun findByCategoriaNome(nomeCategoria: String, paginacao: Pageable):Page<Produto>
}