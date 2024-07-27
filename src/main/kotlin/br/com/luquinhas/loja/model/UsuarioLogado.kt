package br.com.luquinhas.loja.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UsuarioLogado(private val data: Usuario) : UserDetails {

    override fun getPassword(): String = data.senha

    override fun getUsername(): String = data.email

    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
    override fun getAuthorities() = null

}
