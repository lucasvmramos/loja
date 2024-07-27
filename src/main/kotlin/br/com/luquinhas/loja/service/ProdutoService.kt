package br.com.luquinhas.loja.service

import br.com.luquinhas.loja.dto.AtualizarProdutoForm
import br.com.luquinhas.loja.dto.ProdutoForm
import br.com.luquinhas.loja.dto.ProdutoView
import br.com.luquinhas.loja.exception.NotFoundException
import br.com.luquinhas.loja.mapper.ProdutoFormMapper
import br.com.luquinhas.loja.mapper.ProdutoViewMapper
import br.com.luquinhas.loja.repository.ProdutoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProdutoService(
    private val repository: ProdutoRepository,
    private val formMapper: ProdutoFormMapper,
    private val viewMapper: ProdutoViewMapper,
) {

    fun cadastrarProduto(produtoForm: ProdutoForm): ProdutoView {
        val produto = formMapper.map(produtoForm)
        repository.save(produto)
        return viewMapper.map(produto)
    }

    fun buscarPorID(id: Long): ProdutoView {
        val produto = repository
            .findById(id)
            .orElseThrow { NotFoundException("Produto nao encontrado") }
        return viewMapper.map(produto)
    }

    fun buscarTodos(nomeCategoria: String?, paginacao: Pageable): Page<ProdutoView> {
        val produtos = if (nomeCategoria.isNullOrEmpty()){
            repository.findAll(paginacao)
        }else{
            repository.findByCategoriaNome(nomeCategoria,paginacao)
        }
        return produtos.map { p -> viewMapper.map(p) }
    }

    fun removerProduto(id: Long){
        repository.deleteById(id)
    }

    fun atualizar(form: AtualizarProdutoForm): ProdutoView {
        val produto=repository.findById(form.id)
            .orElseThrow { NotFoundException("Produto nao encotrado") }
        produto.nome=form.nome
        produto.valor=form.valor
        repository.save(produto)
        return viewMapper.map(produto)
    }


}