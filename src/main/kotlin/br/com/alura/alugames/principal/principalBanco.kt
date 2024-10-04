package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamerDAO
import br.com.alura.alugames.dados.JogoDAO
import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo

fun main() {
    val manager = Banco.getManagerEntity()
    val jogoDao = JogoDAO(manager)
    
    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.", 5.99)
    jogoDao.adicionaJogo(jogo)

    val gamerVini = Gamer(
        "Vinicius",
        "Vinicius@vinicius.com",
        "21/10/1999",
        "vini@12"
    )

    val gamer = GamerDAO(manager)
    println("Gamer ${gamer.getGamers()}")
    gamer.adicionaGamer(gamerVini)
    gamer.getGamers()
    println("Gamer apos adicionar ${gamer.getGamers()}")

    val jogos = jogoDao.getJogos()
    println(jogos)
}