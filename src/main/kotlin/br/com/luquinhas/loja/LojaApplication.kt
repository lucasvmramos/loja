package br.com.luquinhas.loja

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class LojaApplication

fun main(args: Array<String>) {
	runApplication<LojaApplication>(*args)
}
