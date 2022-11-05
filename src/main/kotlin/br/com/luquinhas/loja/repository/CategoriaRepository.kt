package br.com.luquinhas.loja.repository

import br.com.luquinhas.loja.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaRepository : JpaRepository<Categoria, Long> {
}