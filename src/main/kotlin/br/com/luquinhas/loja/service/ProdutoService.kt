package br.com.luquinhas.loja.service

import br.com.luquinhas.loja.dto.ProdutoForm
import br.com.luquinhas.loja.dto.ProdutoView
import br.com.luquinhas.loja.exception.NotFoundException
import br.com.luquinhas.loja.mapper.ProdutoFormMapper
import br.com.luquinhas.loja.mapper.ProdutoViewMapper
import br.com.luquinhas.loja.repository.ProdutoRepository
import org.springframework.stereotype.Service

@Service
class ProdutoService(
    private val repository: ProdutoRepository,
    private val formMapper: ProdutoFormMapper,
    private val viewMapper: ProdutoViewMapper,
) {

    fun cadastrarProduto(produtoForm: ProdutoForm): ProdutoView {
        val produto = formMapper.map(produtoForm);
        repository.save(produto)
        return viewMapper.map(produto)
    }

    fun buscarPorID(id: Long): ProdutoView {
        val produto = repository
            .findById(id)
            .orElseThrow { NotFoundException("Produto nao encotrado") }
        return viewMapper.map(produto)
    }

    fun buscarTodos(): List<ProdutoView> {
        var produtos = repository
            .findAll()
        return produtos.map { p -> viewMapper.map(p) }
    }

    fun removerProduto(id: Long){
        repository.deleteById(id)
    }

}