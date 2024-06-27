package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.JogoDAO
import br.com.alura.alugames.modelo.Jogo

fun main() {
    val jogoDao = JogoDAO()
    
    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.", 5.99)
    jogoDao.adicionaJogo(jogo)

    val jogos = jogoDao.getJogos()
    println(jogos)
}