package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi

fun main() {
    val consumoApi = ConsumoApi()
    val gamers = consumoApi.buscaGamers()
    println(gamers)

    val meuJogo = consumoApi.buscaJogoPorId("151")
    println(meuJogo)
}