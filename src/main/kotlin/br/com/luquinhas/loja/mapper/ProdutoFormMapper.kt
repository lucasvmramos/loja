package br.com.luquinhas.loja.mapper

import br.com.luquinhas.loja.dto.ProdutoForm
import br.com.luquinhas.loja.model.Produto
import br.com.luquinhas.loja.service.CategoriaService
import org.springframework.stereotype.Component

@Component
class ProdutoFormMapper(
    private val service:CategoriaService
):Mapper<ProdutoForm,Produto> {
    override fun map(t: ProdutoForm): Produto {
        return Produto(
            nome = t.nome,
            valor = t.valor,
            descricao = t.descricao,
            categoria = service.buscarCategoriaPorID(t.categoria)
        )
    }
}