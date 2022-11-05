package br.com.luquinhas.loja.repository

import br.com.luquinhas.loja.model.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository:JpaRepository<Produto,Long> {}