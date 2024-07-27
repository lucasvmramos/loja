package br.com.luquinhas.loja.mapper

import br.com.luquinhas.loja.dto.UsuarioView
import br.com.luquinhas.loja.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioViewMapper:Mapper<Usuario,UsuarioView> {
    override fun map(t: Usuario): UsuarioView {
        return UsuarioView(
            id = t.id,
            nome = t.nome,
            dataCriacao = t.dataCadastro
        )
    }
}