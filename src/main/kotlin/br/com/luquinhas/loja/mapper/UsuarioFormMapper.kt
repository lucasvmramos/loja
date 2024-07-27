package br.com.luquinhas.loja.mapper

import br.com.luquinhas.loja.dto.UsuarioForm
import br.com.luquinhas.loja.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioFormMapper:Mapper<UsuarioForm, Usuario>{

    override fun map(t: UsuarioForm): Usuario {
        return Usuario(
            email = t.email,
            nome = t.nome,
            senha = t.senha
        )
    }

}