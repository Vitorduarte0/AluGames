package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi

fun main() {
    val consumoApi = ConsumoApi()
    val listaGamers = consumoApi.buscaGamers()
    val listaJogoJson = consumoApi.buscaJogos()


    val gamerCamila = listaGamers.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)
    println("--------------------------------------------------")
    println("Desafio Conclusao de curso \n")

//  Formatação de string para fixar duas casas decimais

    gamerCamila.recomendarJogo(jogoResidentVillage, 6)
    gamerCamila.recomendarJogo(jogoResidentVillage, 6)
    gamerCamila.recomendarJogo(jogoResidentVillage, 5)

    gamerCamila.recomendar(6)
    gamerCamila.recomendar(6)
    gamerCamila.recomendar(5)

    println("Informações do gamer: \n$gamerCamila \n")
    println("Informações dos jogos: \n${gamerCamila.jogosRecomendados}")
}