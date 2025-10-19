package br.com.luquinhas.loja.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration{

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain{
         http.csrf{it.disable()}
             .authorizeRequests{
                 it.anyRequest().authenticated()
             }
             .sessionManagement {
                 it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             }
             .formLogin{
                 it.disable()
             }
             .httpBasic()

        return http.build()
    }

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder()
}