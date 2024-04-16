package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Vitor", "Vitor@vitor.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Vinicius",
        "Vinicius@vinicius.com",
        "21/10/1999",
        "vini@12"
    )
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "21/10/1929"
        it.usuario = "vitin-gordin"
    }

}