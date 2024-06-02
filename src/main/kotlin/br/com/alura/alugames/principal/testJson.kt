package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.servicos.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumoApi = ConsumoApi()
    val gamers = consumoApi.buscaGamers()
    val jogos = consumoApi.buscaJogos()

    val gamerCaroline = gamers.get(3)
    val jogoResidentVillage = jogos.get(10)
    val jogo1 = jogos.get(3)
    val jogo2 = jogos.get(12)
    val jogo3 = jogos.get(4)
    val jogo4 = jogos.get(1)

    val periodoJuneInicial = LocalDate.of(2024, 6, 17)
    val periodoJune2Inicial = LocalDate.of(2024, 6, 12)
    val periodoJune3Inicial = LocalDate.of(2024, 6, 6)
    val periodoJulyInicial = LocalDate.of(2024, 7, 17)
    val periodoJuly2Inicial = LocalDate.of(2024, 7, 17)

    val periodo = Periodo(periodoJuneInicial, periodoJuneInicial.plusDays(7))
    val periodo2 = Periodo(periodoJune2Inicial, periodoJune2Inicial.plusDays(5))
    val periodo3 = Periodo(periodoJune3Inicial, periodoJune3Inicial.plusDays(5))
    val periodo4 = Periodo(periodoJulyInicial, periodoJulyInicial.plusDays(10))
    val periodo5 = Periodo(periodoJuly2Inicial, periodoJuly2Inicial.plusDays(27))

    gamerCaroline.alugaJogo(jogoResidentVillage, periodo)
    gamerCaroline.alugaJogo(jogo1, periodo2)
    gamerCaroline.alugaJogo(jogo2, periodo3)
    gamerCaroline.alugaJogo(jogo3, periodo4)
    gamerCaroline.alugaJogo(jogo4, periodo5)

    println(gamerCaroline.jogosAlugados)
    println(gamerCaroline.jogosAlugadosPorMes(periodoJulyInicial))
}