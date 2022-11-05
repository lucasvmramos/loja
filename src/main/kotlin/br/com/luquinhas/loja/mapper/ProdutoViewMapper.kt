package br.com.luquinhas.loja.mapper

import br.com.luquinhas.loja.dto.ProdutoView
import br.com.luquinhas.loja.model.Produto
import org.springframework.stereotype.Component

@Component
class ProdutoViewMapper:Mapper<Produto,ProdutoView> {
    override fun map(t: Produto): ProdutoView {
        return ProdutoView(
            dataCriacao = t.dataCadastro,
            nome = t.nome,
            valor = t.valor
        )
    }
}