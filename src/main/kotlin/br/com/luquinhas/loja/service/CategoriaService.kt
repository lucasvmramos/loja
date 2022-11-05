package br.com.luquinhas.loja.service

import br.com.luquinhas.loja.exception.NotFoundException
import br.com.luquinhas.loja.model.Categoria
import br.com.luquinhas.loja.repository.CategoriaRepository
import org.springframework.stereotype.Service

@Service
class CategoriaService(
    private val repository: CategoriaRepository,
    private val mensagemExcep:String = "Categoria nao encontrada"
) {

    fun cadastrarCategoria(categoria: Categoria): Categoria {
        repository.save(categoria);
        return categoria
    }

    fun buscarCategorias():List<Categoria>{
        return repository.findAll()
    }

    fun buscarCategoriaPorID(id:Long):Categoria{
        return repository.findById(id).orElseThrow{ NotFoundException(mensagemExcep)};
    }

    fun deletarCategoria(id: Long){
        repository.deleteById(id)
    }
}