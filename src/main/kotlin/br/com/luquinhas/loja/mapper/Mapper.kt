package br.com.luquinhas.loja.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}