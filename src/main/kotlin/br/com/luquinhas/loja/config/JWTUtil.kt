package br.com.luquinhas.loja.config

import br.com.luquinhas.loja.model.Rule
import br.com.luquinhas.loja.service.UsuarioService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWTUtil(
    private  val usuarioService: UsuarioService
) {

    private val validadeToken: Long = 60000
    @Value(value = "\${jwt.secret}")
    private lateinit var secret: String

    fun generateToken(username: String, authorities: List<Rule>): String {

        return Jwts.builder()
            .setSubject(username) //subject informacoes do usuario
            .claim("roles",authorities) // adicionar as roles
            .setExpiration(Date(System.currentTimeMillis() + validadeToken)) // tempo de validade agora + 60 segundos
            .signWith(SignatureAlgorithm.HS256,secret.toByteArray()) // tipo do token mais secret
            .compact()
    }

    fun isValid(jwt: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(jwt)
            true
        } catch (e:IllegalArgumentException){
            false
        }
    }

    fun getAuthentication(jwt: String?):Authentication{
        val username = Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(jwt).body.subject
        val user = usuarioService.loadUserByUsername(username)
        return UsernamePasswordAuthenticationToken(username,null,user.authorities)
    }
}