package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File

fun main() {
    val consumoApi = ConsumoApi()
    val listaGamers = consumoApi.buscaGamers()
    val listaJogoJson = consumoApi.buscaJogos()


    val gamerCamila = listaGamers.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)
    val jogoSpider = listaJogoJson.get(13)
    val jogoTheLastOfUs = listaJogoJson.get(2)
    val jogoDandara = listaJogoJson.get(5)
    val jogoAssassins = listaJogoJson.get(4)
    val jogoCyber = listaJogoJson.get(6)
    val jogoGod = listaJogoJson.get(7)
    val jogoSkyrim = listaJogoJson.get(18)

    gamerCamila.recomendarJogo(jogoResidentVillage, 6)
    gamerCamila.recomendarJogo(jogoResidentVillage, 6)
    gamerCamila.recomendarJogo(jogoResidentVillage, 5)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)


    val gsonBuilder = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    val serializerJson = gsonBuilder.toJson(gamerCamila.jogosRecomendados)
    println(gamerCamila.jogosRecomendados)

    val fileJson = File("jogosRecomandos - ${gamerCamila.name}.json")
    fileJson.writeText(serializerJson)
    println(fileJson.absolutePath)



//Essa parte ficou comentanda para nao ficar printando e mudando o comportamento conforme orientacao do curso

//    val gamerCaroline = listaGamers.get(3)
//    val jogo1 = listaJogoJson[3]
//    val jogo2 = listaJogoJson[12]
//    val jogo3 = listaJogoJson[4]
//    val jogo4 = listaJogoJson[1]
//
//    val periodoJuneInicial = LocalDate.of(2024, 6, 17)
//    val periodoJune2Inicial = LocalDate.of(2024, 6, 12)
//    val periodoJune3Inicial = LocalDate.of(2024, 6, 6)
//    val periodoJulyInicial = LocalDate.of(2024, 7, 17)
//    val periodoJuly2Inicial = LocalDate.of(2024, 7, 17)
//
//    val periodo = Periodo(periodoJuneInicial, periodoJuneInicial.plusDays(7))
//    val periodo2 = Periodo(periodoJune2Inicial, periodoJune2Inicial.plusDays(5))
//    val periodo3 = Periodo(periodoJune3Inicial, periodoJune3Inicial.plusDays(5))
//    val periodo4 = Periodo(periodoJulyInicial, periodoJulyInicial.plusDays(10))
//    val periodo5 = Periodo(periodoJuly2Inicial, periodoJuly2Inicial.plusDays(27))
//
//    gamerCaroline.alugaJogo(jogoResidentVillage, periodo)
//    gamerCaroline.alugaJogo(jogo1, periodo2)
//    gamerCaroline.alugaJogo(jogo2, periodo3)
//    gamerCaroline.alugaJogo(jogo3, periodo4)
//    gamerCaroline.alugaJogo(jogo4, periodo5)
//
//    println(gamerCaroline.jogosAlugados)
//    println(gamerCaroline.jogosAlugadosPorMes(7))
//
//    val gamerVitin = listaGamers[2]
////    gamerVitin.plano = PlanoAssinatura("PRATA", 9.9, 3)
//    gamerVitin.alugaJogo(jogo1, periodo)
//    gamerVitin.alugaJogo(jogo2, periodo2)
//    gamerVitin.alugaJogo(jogo3, periodo3)
//    gamerVitin.alugaJogo(jogo4, periodo4)
//    println(gamerVitin.jogosAlugados)
//    gamerVitin.recomendar(7)
//    gamerVitin.recomendar(8)
//    gamerVitin.recomendar(10)
//    gamerVitin.alugaJogo(jogoResidentVillage, periodo)
//    println(gamerVitin.jogosAlugados)


}